package com.silverhetch.clotho.source

import com.silverhetch.clotho.Source

/**
 * Const source that only keeps the reference.
 * @todo #refactor-1 remove this class which is redundant
 */
class ConstSource<T>(private val value: T) : Source<T> {
    override fun value(): T {
        return value
    }
}