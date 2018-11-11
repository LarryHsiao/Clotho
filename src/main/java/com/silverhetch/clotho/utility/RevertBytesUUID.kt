package com.silverhetch.clotho.utility

import com.silverhetch.clotho.Source
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*

/**
 * Order uuid bytes with little endianess
 */
class RevertBytesUUID(private val input: UUID) : Source<UUID> {
    override fun fetch(): UUID {
        val buffer =  ByteBuffer.allocate(16)
        buffer.putLong(input.leastSignificantBits)
        buffer.putLong(input.mostSignificantBits)
        buffer.rewind()
        buffer.order(ByteOrder.LITTLE_ENDIAN)
        return UUID(buffer.long, buffer.long)
    }
}