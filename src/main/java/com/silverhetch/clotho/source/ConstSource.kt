package com.silverhetch.clotho.source

import com.silverhetch.clotho.Source

/**
 * Const source that only keeps the reference.
 */
class ConstSource<T>(private val value: T) : Source<T> {
    override fun fetch(): T {
        return value
    }
}