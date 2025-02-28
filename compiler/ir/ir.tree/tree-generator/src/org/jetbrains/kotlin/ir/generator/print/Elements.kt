/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.generator.print

import org.jetbrains.kotlin.generators.tree.*
import org.jetbrains.kotlin.generators.tree.printer.*
import org.jetbrains.kotlin.ir.generator.BASE_PACKAGE
import org.jetbrains.kotlin.ir.generator.TREE_GENERATOR_README
import org.jetbrains.kotlin.ir.generator.elementTransformerType
import org.jetbrains.kotlin.ir.generator.elementVisitorType
import org.jetbrains.kotlin.ir.generator.model.*
import org.jetbrains.kotlin.ir.generator.model.ListField
import org.jetbrains.kotlin.ir.generator.model.Model
import org.jetbrains.kotlin.utils.SmartPrinter
import org.jetbrains.kotlin.utils.withIndent
import java.io.File
import org.jetbrains.kotlin.generators.tree.ElementRef as GenericElementRef

private val transformIfNeeded = ArbitraryImportable("$BASE_PACKAGE.util", "transformIfNeeded")
private val transformInPlace = ArbitraryImportable("$BASE_PACKAGE.util", "transformInPlace")

private class ElementPrinter(printer: SmartPrinter) : AbstractElementPrinter<Element, Field>(printer) {

    override fun makeFieldPrinter(printer: SmartPrinter) = object : AbstractFieldPrinter<Field>(printer) {
        override fun forceMutable(field: Field) = field.isMutable
    }

    override fun defaultElementKDoc(element: Element) =
        "A ${if (element.isLeaf) "leaf" else "non-leaf"} IR tree element."

    override val separateFieldsWithBlankLine: Boolean
        get() = true

    context(ImportCollector)
    override fun SmartPrinter.printAdditionalMethods(element: Element) {
        element.generationCallback?.invoke(this@ImportCollector, this)

        printAcceptMethod(
            element = element,
            visitorClass = elementVisitorType,
            hasImplementation = !element.isRootElement,
            treeName = "IR",
        )

        printTransformMethod(
            element = element,
            transformerClass = elementTransformerType,
            implementation = "accept(transformer, data)".takeIf { !element.isRootElement },
            returnType = element,
            treeName = "IR",
        )

        if (element.hasAcceptChildrenMethod) {
            printAcceptChildrenMethod(
                element = element,
                visitorClass = elementVisitorType,
                visitorResultType = StandardTypes.unit,
                override = !element.isRootElement,
            )

            if (!element.isRootElement) {
                printBlock {
                    for (child in element.walkableChildren) {
                        print(child.name)
                        if (child.nullable) {
                            print("?")
                        }
                        when (child) {
                            is SingleField -> println(".accept(visitor, data)")
                            is ListField -> {
                                print(".forEach { it")
                                if (child.baseType.nullable) {
                                    print("?")
                                }
                                println(".accept(visitor, data) }")
                            }
                        }
                    }
                }
            } else {
                println()
            }
        }

        if (element.hasTransformChildrenMethod) {
            printTransformChildrenMethod(
                element = element,
                transformerClass = elementTransformerType,
                returnType = StandardTypes.unit,
                override = !element.isRootElement,
            )
            if (!element.isRootElement) {
                printBlock {
                    for (child in element.transformableChildren) {
                        print(child.name)
                        when (child) {
                            is SingleField -> {
                                print(" = ", child.name)
                                if (child.nullable) {
                                    print("?")
                                }
                                print(".transform(transformer, data)")
                                val elementRef = child.typeRef as GenericElementRef<*, *>
                                if (!elementRef.element.hasTransformMethod) {
                                    print(" as ", elementRef.render())
                                }
                                println()
                            }
                            is ListField -> {
                                if (child.isMutable) {
                                    print(" = ", child.name)
                                    if (child.nullable) {
                                        print("?")
                                    }
                                    addImport(transformIfNeeded)
                                    println(".transformIfNeeded(transformer, data)")
                                } else {
                                    addImport(transformInPlace)
                                    println(".transformInPlace(transformer, data)")
                                }
                            }
                        }
                    }
                }
            } else {
                println()
            }
        }
    }
}

fun printElements(generationPath: File, model: Model) = model.elements.map { element ->
    printGeneratedType(generationPath, TREE_GENERATOR_README, element.packageName, element.typeName) {
        addAllImports(element.usedTypes)
        ElementPrinter(this).printElement(element)
    }
}
