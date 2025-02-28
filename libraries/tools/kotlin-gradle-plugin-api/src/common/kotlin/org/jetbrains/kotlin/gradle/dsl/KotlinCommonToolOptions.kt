// DO NOT EDIT MANUALLY!
// Generated by org/jetbrains/kotlin/generators/arguments/GenerateGradleOptions.kt
// To regenerate run 'generateGradleOptions' task
@file:Suppress("RemoveRedundantQualifierName", "Deprecation", "DuplicatedCode")

package org.jetbrains.kotlin.gradle.dsl

interface KotlinCommonToolOptions {
    val options: org.jetbrains.kotlin.gradle.dsl.KotlinCommonCompilerToolOptions

    /**
     * Report an error if there are any warnings.
     * Default value: false
     */
    var allWarningsAsErrors: kotlin.Boolean
        get() = options.allWarningsAsErrors.get()
        set(value) = options.allWarningsAsErrors.set(value)

    /**
     * Don't generate any warnings.
     * Default value: false
     */
    var suppressWarnings: kotlin.Boolean
        get() = options.suppressWarnings.get()
        set(value) = options.suppressWarnings.set(value)

    /**
     * Enable verbose logging output.
     * Default value: false
     */
    var verbose: kotlin.Boolean
        get() = options.verbose.get()
        set(value) = options.verbose.set(value)

    /**
     * A list of additional compiler arguments
     * Default value: emptyList<String>()
     */
    var freeCompilerArgs: kotlin.collections.List<kotlin.String>
        get() = options.freeCompilerArgs.get()
        set(value) = options.freeCompilerArgs.set(value)
}
