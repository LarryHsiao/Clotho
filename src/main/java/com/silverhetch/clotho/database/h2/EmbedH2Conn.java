package com.silverhetch.clotho.database.h2;

import com.silverhetch.clotho.Source;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection to Embed h2
 */
public class EmbedH2Conn implements Source<Connection> {
    private final Source<File> root;

    public EmbedH2Conn(Source<File> root) {
        this.root = root;
    }

    @Override
    public Connection value() {
        try {
            return DriverManager.getConnection("jdbc:h2:" +
                root.value().getAbsolutePath() +
                ";FILE_LOCK=FS" +
                ";PAGE_SIZE=1024" +
                ";CACHE_SIZE=8192");
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
