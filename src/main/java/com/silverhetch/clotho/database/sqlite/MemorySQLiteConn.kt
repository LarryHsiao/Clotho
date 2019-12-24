package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.Source
import java.sql.Connection

/**
 * SQLite database in pure memory. Each instance opens a different database.
 */
class MemorySQLiteConn : Source<Connection> {
    override fun value(): Connection {
        return SQLiteConn(":memory:").value()
    }
}