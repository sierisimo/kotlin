/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.java

import org.jetbrains.kotlin.fir.symbols.impl.FirTypeParameterSymbol
import org.jetbrains.kotlin.load.java.structure.JavaTypeParameter

class MutableJavaTypeParameterStack : JavaTypeParameterStack() {
    private val typeParameterMap = mutableMapOf<JavaTypeParameter, FirTypeParameterSymbol>()

    fun addParameter(javaTypeParameter: JavaTypeParameter, symbol: FirTypeParameterSymbol) {
        typeParameterMap[javaTypeParameter] = symbol
    }

    fun addStack(javaTypeParameterStack: MutableJavaTypeParameterStack) {
        typeParameterMap += javaTypeParameterStack.typeParameterMap
    }

    override operator fun get(javaTypeParameter: JavaTypeParameter): FirTypeParameterSymbol {
        return typeParameterMap[javaTypeParameter]
            ?: throw IllegalArgumentException("Cannot find Java type parameter $javaTypeParameter in stack")
    }

    override operator fun iterator(): Iterator<Map.Entry<JavaTypeParameter, FirTypeParameterSymbol>> {
        return typeParameterMap.iterator()
    }

}

abstract class JavaTypeParameterStack : Iterable<Map.Entry<JavaTypeParameter, FirTypeParameterSymbol>> {
    abstract operator fun get(javaTypeParameter: JavaTypeParameter): FirTypeParameterSymbol

    companion object {
        val EMPTY: JavaTypeParameterStack = MutableJavaTypeParameterStack()
    }
}
