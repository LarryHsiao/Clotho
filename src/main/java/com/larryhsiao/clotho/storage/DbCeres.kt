package com.larryhsiao.clotho.storage

import com.larryhsiao.clotho.Source
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

    override fun delete(key: String?) {
        dbConn.value().prepareStatement(
            """
            delete FROM ceres 
            where key=?1;
        """
        ).use { statement ->
            statement.setString(1, key)
            statement.execute()
            if (statement.updateCount == 0) {
                throw SQLException("Delete failed")
            }
        }
    }
}