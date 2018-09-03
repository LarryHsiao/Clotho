package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.Source
import java.sql.Connection

/**
 * A sqlite database actually create temporary file. Each instance has separates database.
 */
class TempConn : Source<Connection> {
    private lateinit var conn: Source<Connection>
    override fun fetch(): Connection {
        if (!::conn.isInitialized) {
            conn = SQLiteConn("")
        }
        return conn.fetch()
    }
}