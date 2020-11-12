package com.larryhsiao.clotho.source

import com.larryhsiao.clotho.Source

/**
 * Decorator Source to hold the reference of origin.
 *
 * The value() only returns same reference all the time.
 */
class SingleRefSource<T>(private val origin: Source<T>) : Source<T> {
    private var ref: T? = null
    override fun value(): T {
        if (ref == null) {
            ref = origin.value()
        }
        return ref ?: origin.value()
    }
}