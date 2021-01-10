package io.github.noyzys.top.structure.user.repository.database

import io.github.noyzys.top.database.DatabaseConnectionProvider
import io.github.noyzys.top.structure.user.TopUser
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*

typealias RecordScore = ResultSet.() -> Unit
typealias AcceptingPreparedStatement = PreparedStatement.() -> Unit

/**
 * @author: noyzys on 20:15, 10.01.2021
 **/
class TopDatabaseRepository(
    private val databaseConnectionProvider: DatabaseConnectionProvider
) {

    lateinit var users: Map<UUID, TopUser>

    private fun <T> ResultSet.map(recordScore: RecordScore) =
        use { generateSequence { if (next()) recordScore(this) else null } }

    private fun makeStatement(sql: String, acceptingPreparedStatement: AcceptingPreparedStatement) =
        databaseConnectionProvider.acquire().use { connection ->
            connection.prepareStatement(sql).apply(acceptingPreparedStatement)
        }

    fun createTable() {
        databaseConnectionProvider.acquire().use { connection ->
            connection.createStatement().executeQuery(TopDatabaseQueriesConstants.CREATE_TABLE_QUERY)
        }
    }

    fun insertUser(topUser: TopUser) = makeStatement(TopDatabaseQueriesConstants.INSERT_QUERY) {
        setString(0, topUser.uniqueId.toString())
        setString(1, topUser.nickName)
        setInt(2, topUser.kills)
    }.execute()

    fun saveUser(topUser: TopUser) = makeStatement(TopDatabaseQueriesConstants.UPDATE_QUERY) {
        setString(2, topUser.uniqueId.toString())
        setString(1, topUser.nickName)
        setInt(1, topUser.kills)
    }.execute()
}
