package com.larryhsiao.clotho.dgist;

import com.larryhsiao.clotho.Source;

import java.util.Formatter;

/**
 * Convert to hex from given bytes.
 */
public class HexString implements Source<String> {
    private final byte[] input;

    public HexString(byte[] input) {this.input = input;}

    @Override
    public String value() {
        final Formatter formatter = new Formatter();
        for (byte b : input) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
}
