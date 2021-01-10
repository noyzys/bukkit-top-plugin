package io.github.noyzys.top.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

/**
 * @author: noyzys on 17:41, 10.01.2021
 **/
class DatabaseConnectionConfiguration {

    private val host = "xd"
    private val port = 3306
    private val database = "xd"
    private val user = "xd"
    private val password = "xd"

    fun toDataSource(): HikariDataSource {
        val config = HikariConfig()

        config.apply {
            config.jdbcUrl = "dbc:mysql://${host}:${port}/${database}?useSSL=false"
            config.username = user
            config.password = password

            config.addDataSourceProperty("cachePrepStmts", true)
            config.addDataSourceProperty("prepStmtCacheSize", 250)
            config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048)
            config.addDataSourceProperty("useServerPrepStmts", true)

            config.validate()
        }

        return HikariDataSource(config)
    }
}