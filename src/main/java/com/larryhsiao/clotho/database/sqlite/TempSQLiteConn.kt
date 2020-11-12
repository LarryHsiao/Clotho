package com.larryhsiao.clotho.database.sqlite

import com.larryhsiao.clotho.Source
import java.sql.Connection

/**
 * A sqlite database actually create temporary file. Each instance has separates database.
 */
class TempSQLiteConn : Source<Connection> {
    override fun value(): Connection {
        return SQLiteConn("").value()
    }
}