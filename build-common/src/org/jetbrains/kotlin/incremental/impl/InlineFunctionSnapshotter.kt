/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.incremental.impl

import org.jetbrains.org.objectweb.asm.MethodVisitor
import org.jetbrains.org.objectweb.asm.Opcodes
import org.jetbrains.org.objectweb.asm.util.Textifier
import org.jetbrains.org.objectweb.asm.util.TraceMethodVisitor

/**
 * //TODO i can write a nice doc if it actually works
 */
internal class InlineFunctionSnapshotter {
    /**
     * //TODO same as class
     * but the idea is that this should handle inline lambdas and other nasty cases
     * pretty sure there are cases where a simple val is changed and it's also broken
     * i can add a test or something
     */

    //TODO name
    val bodyHashes = HashMap<String, Long>()
    private val textifier = Textifier()

//    fun methodVisitor
//        // TODO clean up api
//        (visitor: org.jetbrains.org.objectweb.asm.ClassVisitor) : MethodVisitor {
//            val methodVisitor = object : MethodVisitor(Opcodes.ASM9, visitor.visitMethod()) {
//
//                override fun visitEnd() {
//                    println("visit end of methodvisitor")
//                    val justDebug = textifier.getText()
//                    //TODO put the printer.gettext into the map
//                    super.visitEnd()
//                }
//
//            }
//            return TraceMethodVisitor(methodVisitor, textifier)
//        }



    fun getFunctionInstructionsHash() {

    }
}
