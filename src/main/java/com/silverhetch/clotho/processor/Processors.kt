package com.silverhetch.clotho.processor

import com.silverhetch.clotho.log.Log
import com.silverhetch.clotho.log.PhantomLog
import java.lang.Exception

/**
 * Decorator to proceed input object with multiple [Processor]
 */
class Processors<T>(
    private vararg val processors: Processor<T>
) : Processor<T> {
    override fun proceed(input: T) {
        try {
            processors.forEach {
                it.proceed(input)
            }
        } catch (ignore: Exception) {
            // Not proceed to next processor, abort the process.
        }
    }
}