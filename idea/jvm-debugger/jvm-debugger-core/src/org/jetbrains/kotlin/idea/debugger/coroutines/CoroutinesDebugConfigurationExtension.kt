/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
package org.jetbrains.kotlin.idea.debugger.coroutines

import com.intellij.debugger.DebuggerInvocationUtil
import com.intellij.debugger.DebuggerManagerEx
import com.intellij.debugger.actions.ThreadDumpAction
import com.intellij.debugger.impl.DebuggerSession
import com.intellij.execution.RunConfigurationExtension
import com.intellij.execution.configurations.DebuggingRunnerData
import com.intellij.execution.configurations.JavaParameters
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunnerSettings
import com.intellij.execution.ui.RunnerLayoutUi
import com.intellij.execution.ui.layout.PlaceInGrid
import com.intellij.execution.ui.layout.impl.RunnerContentUi
import com.intellij.execution.ui.layout.impl.RunnerLayoutUiImpl
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.registry.Registry
import com.intellij.ui.content.ContentManagerAdapter
import com.intellij.ui.content.ContentManagerEvent
import com.intellij.util.messages.MessageBusConnection
import com.intellij.xdebugger.XDebugProcess
import com.intellij.xdebugger.XDebuggerManager
import com.intellij.xdebugger.XDebuggerManagerListener
import org.jetbrains.kotlin.psi.UserDataProperty

/**
 * Installs coroutines debug agent and coroutines tab if `kotlinx.coroutines.debug` dependency is found
 */
@Suppress("IncompatibleAPI")
class CoroutinesDebugConfigurationExtension : RunConfigurationExtension() {
    private var Project.listenerCreated: Boolean? by UserDataProperty(Key.create("COROUTINES_DEBUG_TAB_CREATE_LISTENER"))

    override fun isApplicableFor(configuration: RunConfigurationBase<*>): Boolean {
        return Registry.`is`("kotlin.debugger" + ".coroutines")
    }

    override fun <T : RunConfigurationBase<*>?> updateJavaParameters(
        configuration: T,
        params: JavaParameters?,
        runnerSettings: RunnerSettings?
    ) {
        if (!Registry.`is`("kotlin.debugger" + ".coroutines")) return
        if (runnerSettings is DebuggingRunnerData && params != null
            && params.classPath != null
            && params.classPath.pathList.isNotEmpty()
        ) {
            params.classPath.pathList.forEach {
                if (!it.contains("kotlinx-coroutines-debug")) return@forEach
                // if debug library is included into project, add agent which installs probes
                params.vmParametersList?.add("-javaagent:$it")
                params.vmParametersList?.add("-ea")
                val project = (configuration as RunConfigurationBase<*>).project
                // add listener to put coroutines tab into debugger tab
                if (project.listenerCreated != true) { // prevent multiple listeners creation
                    val connection = project.messageBus.connect()
                    connection.subscribe(
                        XDebuggerManager.TOPIC, createListener(project, connection)
                    )
                    project.listenerCreated = true
                    return
                }
            }

        }
    }

    private fun createListener(project: Project, connection: MessageBusConnection): XDebuggerManagerListener {
        return object : XDebuggerManagerListener {
            override fun processStarted(debugProcess: XDebugProcess) {
                DebuggerInvocationUtil.swingInvokeLater(project) {
                    val session = DebuggerManagerEx.getInstanceEx(project).context.debuggerSession
                    if (session != null)
                        registerCoroutinesPanel(session.xDebugSession?.ui ?: return@swingInvokeLater, session)
                }
            }

            override fun processStopped(debugProcess: XDebugProcess) {
                connection.disconnect()
                project.listenerCreated = false
            }
        }
    }

    /**
     * Adds panel to XDebugSessionTab
     */
    private fun registerCoroutinesPanel(ui: RunnerLayoutUi, session: DebuggerSession) {
        val panel = CoroutinesPanel(session.project, session.contextManager)
        val content = ui.createContent(
            "CoroutinesContent", panel, "Coroutines", // TODO(design)
            AllIcons.Debugger.ThreadGroup, null
        )
        content.isCloseable = false
        ui.addContent(content, 0, PlaceInGrid.left, true)
        ui.addListener(object : ContentManagerAdapter() {
            override fun selectionChanged(event: ContentManagerEvent) {
                if (event.content === content) {
                    if (content.isSelected) {
                        panel.setUpdateEnabled(true)
                        if (panel.isRefreshNeeded) {
                            panel.rebuildIfVisible(DebuggerSession.Event.CONTEXT)
                        }
                    } else {
                        panel.setUpdateEnabled(false)
                    }
                }
            }
        }, content)
        // add coroutine dump button: due to api problem left toolbar is copied, modified and reset to tab
        val runnerContent = (ui.options as RunnerLayoutUiImpl).getData(RunnerContentUi.KEY.name) as RunnerContentUi
        val modifiedActions = runnerContent.getActions(true)
        val pos = modifiedActions.indexOfLast { it is ThreadDumpAction }
        modifiedActions.add(pos + 1, ActionManager.getInstance().getAction("Kotlin.XDebugger.CoroutinesDump"))
        ui.options.setLeftToolbar(DefaultActionGroup(modifiedActions), ActionPlaces.DEBUGGER_TOOLBAR)
    }

}