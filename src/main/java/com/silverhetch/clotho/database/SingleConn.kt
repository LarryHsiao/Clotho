package com.silverhetch.clotho.database

import com.silverhetch.clotho.Source
import java.sql.Connection

/**
 * Connection decorator to maintain single connection.
 */
class SingleConn(private val source: Source<Connection>) : Source<Connection> {
    private lateinit var connection: Connection
    override fun value(): Connection {
        if (!::connection.isInitialized || connection.isClosed) {
            connection = source.value()
        }
        return connection
    }
}