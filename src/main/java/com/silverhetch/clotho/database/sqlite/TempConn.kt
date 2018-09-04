package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.Source
import java.sql.Connection

/**
 * A sqlite database actually create temporary file. Each instance has separates database.
 */
class TempConn : Source<Connection> {
    override fun fetch(): Connection {
        return SQLiteConn("").fetch()
    }
}