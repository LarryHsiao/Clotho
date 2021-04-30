package com.larryhsiao.clotho.identity;

import com.larryhsiao.clotho.Source;
import com.larryhsiao.clotho.file.FileText;
import com.larryhsiao.clotho.file.TextFile;

import java.io.File;
import java.util.UUID;

/**
 * A source build a UUID string for this device to identify it self.
 */
public class DeviceUUID implements Source<String> {
    private final File idFile;

    public DeviceUUID(File root) {
        this.idFile = new File(root, "uuid.txt");
    }

    @Override
    public String value() {
        if (idFile.exists()) {
            return UUID.fromString(new FileText(
                idFile
            ).value()).toString();
        } else {
            final String uuid = UUID.randomUUID().toString();
            new TextFile(idFile, uuid).value();
            return uuid;
        }
    }
}
