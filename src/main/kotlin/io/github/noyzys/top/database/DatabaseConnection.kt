package io.github.noyzys.top.database

import com.zaxxer.hikari.HikariDataSource
import org.slf4j.Logger
import java.util.concurrent.Executors
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

/**
 * @author: noyzys on 17:47, 10.01.2021
 **/
class DatabaseConnection(
    private val dataSource: HikariDataSource,
    private val log: Logger
) {

    // then a refactor for kotlin-coroutines
    private val executorService = Executors.newSingleThreadExecutor()

    @ExperimentalTime
    fun shutdown() = try {
        dataSource.close()
    } catch (ex: Exception) {
        log.info("Could not shutdown the database", ex)
    } finally {
        try {

            executorService.shutdown()
            executorService.awaitTermination(10, DurationUnit.SECONDS)
        } catch (ex: InterruptedException) {
            log.info("Could not shutdown executor for the database", ex)
        }
    }
}