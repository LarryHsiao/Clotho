package com.larryhsiao.clotho.database.h2;

import com.larryhsiao.clotho.Source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Source to build In-Memory h2 connection.
 */
public class MemoryH2Conn implements Source<Connection> {
    private final String dbName;
    public MemoryH2Conn(String name) {
        this.dbName = name;
    }

    public MemoryH2Conn() {
        this(UUID.randomUUID().toString().substring(0, 7));
    }

    @Override
    public Connection value() {
        try {
            return DriverManager.getConnection("jdbc:h2:mem:test-" + dbName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
