package com.larryhsiao.clotho.utility.coffeepot.phantom

import java.util.concurrent.TimeUnit

/**
 * Phantom object of [Parameters].
 */
internal class PhantomParameters(private val millisecond: Long = TimeUnit.SECONDS.toMillis(30)) : Parameters {
    override fun duration(): Long {
        return millisecond
    }
}