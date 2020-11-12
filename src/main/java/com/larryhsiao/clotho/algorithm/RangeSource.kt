package com.larryhsiao.clotho.algorithm

import com.larryhsiao.clotho.Source

/**
 * Source to find the Range (largest and smallest) value which wrapped in object.
 */
class RangeSource(private val numbers: Source<Iterable<Long>>) : Source<Pair<Long, Long>> {
    override fun value(): Pair<Long, Long> {
        var largest = Long.MIN_VALUE
        var smallest = Long.MAX_VALUE

        numbers.value().forEach {
            if (largest < it) {
                largest = it
            }

            if (smallest > it) {
                smallest = it
            }
        }
        return Pair(largest, smallest)
    }
}