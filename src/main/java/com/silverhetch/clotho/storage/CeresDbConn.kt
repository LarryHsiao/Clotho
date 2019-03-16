package com.silverhetch.clotho.storage

import com.silverhetch.clotho.Source
import java.sql.Connection

class CeresDbConn(private val connection: Source<Connection>) : Source<Connection> {
    override fun value(): Connection {
        return connection.value().apply {
            this.createStatement().use {
                it.execute("""
                    create table if not exists ceres (
                      id    integer primary key autoincrement,
                      key   text not null unique,
                      value text not null
                    );""")
            }
        }
    }
}