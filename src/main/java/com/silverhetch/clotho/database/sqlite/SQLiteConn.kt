package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.Source
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Source of SQLite connection.
 */
class SQLiteConn(private val name: String) : Source<Connection> {
    override fun fetch(): Connection {
        try {
            return DriverManager.getConnection("jdbc:sqlite:$name")
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
    }
}