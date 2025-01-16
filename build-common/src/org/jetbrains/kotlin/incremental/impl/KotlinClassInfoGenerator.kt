/*
 * Copyright 2010-2025 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.incremental.impl

import org.jetbrains.kotlin.incremental.KotlinClassInfo
import org.jetbrains.kotlin.load.kotlin.header.KotlinClassHeader
import org.jetbrains.kotlin.name.ClassId

/**
 * We need to provide the normal behavior for compatibility with pre-depgraph JPS,
 * but we also need to allow configurable behavior for Gradle Classpath Snapshotting transformations
 *
 * Current jps implements its own module structure model, so eventually
 * api snapshotting logic could be removed from build-common
 */
class KotlinClassInfoGenerator(
    val context: Context = Context()
) {
    /**
     * This is NOT a stable API. Existing users rely on [KotlinClassInfo.createFrom].
     *
     * Context would be expanded to support cases where class info creation depends on shared info
     * or should update shared info.
     *
     * KotlinClassInfo uses it as a singleton, so default Context should be lightweight.
     */
    data class Context(
        val useInlinedLocalClassesAsPartOfInlineFunctionHash: Boolean = false
    )

    fun createFrom(classId: ClassId, classHeader: KotlinClassHeader, classContents: ByteArray): KotlinClassInfo {
        return KotlinClassInfo(
            classId,
            classHeader.kind,
            classHeader.data ?: classHeader.incompatibleData ?: emptyArray(),
            classHeader.strings ?: emptyArray(),
            classHeader.multifileClassName,
            //TODO (KT-62555) here extra info generator would use context for a more advanced behavior
            extraInfo = ExtraClassInfoGenerator.getExtraInfo(classHeader, classContents)
        )
    }
}
