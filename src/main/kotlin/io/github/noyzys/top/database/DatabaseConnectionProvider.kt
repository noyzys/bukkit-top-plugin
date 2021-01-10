package io.github.noyzys.top.database

import com.zaxxer.hikari.HikariDataSource
import java.sql.Connection
import java.sql.SQLException

/**
 * @author: noyzys on 17:47, 10.01.2021
 **/
class DatabaseConnectionProvider(
    private val dataSource: HikariDataSource
) {

    @Throws(SQLException::class)
    fun acquire(): Connection =
        dataSource.connection
}