package com.silverhetch.clotho.storage

import com.silverhetch.clotho.Source
import java.sql.Connection
import java.sql.SQLException

class DbCeres(dbConn: Source<Connection>) : Ceres {
    private val dbConn = CeresDbConn(dbConn)

    override fun store(key: String, value: String) {
        dbConn.value().prepareStatement("""
            insert or replace into ceres (key, value)
            values (?, ?);
        """).use { statement ->
            statement.setString(1, key)
            statement.setString(2, value)
            statement.execute()
            statement.generatedKeys.use {
                if (!it.next()) {
                    throw SQLException("Store failed")
                }
            }
        }
    }

    override fun get(key: String): String {
        dbConn.value().prepareStatement("""
                select *
                from ceres
                where key=?;""").use {
            it.setString(1, key)
            it.executeQuery().use { result ->
                return if (result.next()) {
                    result.getString(result.findColumn("value"))
                } else {
                    ""
                }
            }
        }
    }

    override fun all(): Map<String, String> {
        dbConn.value().createStatement().use {
            it.executeQuery("""
              select *
              from ceres;
            """).use { resultSet ->
                val resultMap = HashMap<String, String>()
                while (resultSet.next()) {
                    resultMap[resultSet.getString(resultSet.findColumn("key"))] = resultSet.getString(resultSet.findColumn("value"))
                }
                return resultMap
            }
        }
    }
}