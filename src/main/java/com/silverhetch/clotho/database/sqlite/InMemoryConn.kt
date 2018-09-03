package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.Source
import java.sql.Connection

/**
 * SQLite database in pure memory. Each instance opens a different database.
 */
class InMemoryConn : Source<Connection> {
    private lateinit var conn: Source<Connection>
    override fun fetch(): Connection {
        if (!::conn.isInitialized) {
            conn = SQLiteConn(":memory:")
        }
        return conn.fetch()
    }
}