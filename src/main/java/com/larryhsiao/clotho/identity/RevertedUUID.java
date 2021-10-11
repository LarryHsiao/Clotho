package com.larryhsiao.clotho.identity;

import com.larryhsiao.clotho.Source;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/**
 * Order uuid bytes with little endianess
 */
public class RevertedUUID implements Source<UUID> {
    private final UUID input;

    public RevertedUUID(UUID input) {this.input = input;}

    @Override
    public UUID value() {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(input.getLeastSignificantBits());
        buffer.putLong(input.getMostSignificantBits());
        buffer.rewind();
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return new UUID(buffer.getLong(), buffer.getLong());
    }
}
