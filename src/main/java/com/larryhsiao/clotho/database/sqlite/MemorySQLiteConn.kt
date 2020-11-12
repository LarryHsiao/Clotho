package com.larryhsiao.clotho.database.sqlite

import com.larryhsiao.clotho.Source
import java.sql.Connection

/**
 * SQLite database in pure memory. Each instance opens a different database.
 */
class MemorySQLiteConn : Source<Connection> {
    override fun value(): Connection {
        return SQLiteConn(":memory:").value()
    }
}