package com.silverhetch.clotho.utility.coffeepot.phantom

import java.util.concurrent.TimeUnit

internal class PhantomParameters(private val millisecond: Long = TimeUnit.SECONDS.toMillis(30)) : Parameters {
    override fun duration(): Long {
        return millisecond
    }
}