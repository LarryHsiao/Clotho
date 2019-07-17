package com.silverhetch.clotho.media;

import com.silverhetch.clotho.Action;
import com.silverhetch.clotho.file.FileBytes;

import java.io.*;
import java.nio.ByteBuffer;

import static java.nio.ByteOrder.LITTLE_ENDIAN;

/**
 * Action to convert PCM　raw audio file into playable Wave file.
 */
public class PcmToWav implements Action {
    private final File raw;
    private final File target;

    public PcmToWav(File pcmFile, File wavFile) {
        this.raw = pcmFile;
        this.target = wavFile;
    }

    @Override
    public void fire() {
        try {
            rawToWave(raw, target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void rawToWave(final File rawFile, final File waveFile) throws IOException {
        byte[] rawData = new FileBytes(rawFile).value();
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(new FileOutputStream(waveFile));
            // RIFF HEADER
            writeString(output, "RIFF"); // chunk id
            writeInt(output, 36 + rawData.length); // chunk size
            writeString(output, "WAVE"); // format
            // The 1st subchunk describes sound data`s format
            writeString(output, "fmt "); // subchunk 1 id
            writeInt(output, 16); // subchunk1Size
            writeShort(output, (short) 1); // audio format (1 = PCM), Values other than 1 indicate some form of compression.
            writeShort(output, (short) 1); // number of channels: Mono = 1, Stereo = 2, etc.
            writeInt(output, 44100); // sample rate
            writeInt(output, 44100 * 2); // byteRate == SampleRate * NumChannels * BitsPerSample/8
            writeShort(output, (short) 2); // blockAlign == NumChannels * BitsPerSample/8
            writeShort(output, (short) 16); // bits per sample

            // The 2nd subchunk "data" contains the size of the data and the actual sound:
            writeString(output, "data"); // subchunk2Id == data
            writeInt(output, rawData.length); // subchunk2Size == NumSamples * NumChannels * BitsPerSample/8
            // Audio data (conversion big endian -> little endian)
            short[] shorts = new short[rawData.length / 2];
            ByteBuffer.wrap(rawData).order(LITTLE_ENDIAN).asShortBuffer().get(shorts);
            ByteBuffer bytes = ByteBuffer.allocate(shorts.length * 2);
            for (short s : shorts) {
                bytes.putShort(s);
            }
            output.write(appendFile(rawFile));
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    private byte[] appendFile(File f) throws IOException {
        int size = (int) f.length();
        byte[] bytes = new byte[size];
        byte[] tmpBuff = new byte[size];
        FileInputStream fis = new FileInputStream(f);
        try {
            int read = fis.read(bytes, 0, size);
            if (read < size) {
                int remain = size - read;
                while (remain > 0) {
                    read = fis.read(tmpBuff, 0, remain);
                    System.arraycopy(tmpBuff, 0, bytes, size - remain, read);
                    remain -= read;
                }
            }
        } finally {
            fis.close();
        }
        return bytes;
    }

    private void writeInt(final DataOutputStream output, final int value) throws IOException {
        output.write(value);
        output.write(value >> 8);
        output.write(value >> 16);
        output.write(value >> 24);
    }

    private void writeShort(final DataOutputStream output, final short value) throws IOException {
        output.write(value);
        output.write(value >> 8);
    }

    private void writeString(final DataOutputStream output, final String value) throws IOException {
        for (int i = 0; i < value.length(); i++) {
            output.write(value.charAt(i));
        }
    }
}
