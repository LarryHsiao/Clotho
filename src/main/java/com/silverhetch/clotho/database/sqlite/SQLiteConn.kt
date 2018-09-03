package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.Source
import java.sql.Connection
import java.sql.DriverManager

/**
 * Source of SQLite connection.
 */
class SQLiteConn(private val name: String) : Source<Connection> {
    override fun fetch(): Connection {
        try {
            return DriverManager.getConnection("jdbc:sqlite:$name")
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}