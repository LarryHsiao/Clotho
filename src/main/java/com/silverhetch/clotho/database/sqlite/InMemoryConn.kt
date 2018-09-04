package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.Source
import java.sql.Connection

/**
 * SQLite database in pure memory. Each instance opens a different database.
 */
class InMemoryConn : Source<Connection> {
    override fun fetch(): Connection {
        return SQLiteConn(":memory:").fetch()
    }
}