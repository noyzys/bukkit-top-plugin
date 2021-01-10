package io.github.noyzys.top.structure.user.repository

import io.github.noyzys.top.TopPlugin
import io.github.noyzys.top.structure.user.TopUser
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.bukkit.entity.Player
import java.util.*
import kotlin.collections.HashMap

/**
 * @author: noyzys on 17:28, 10.01.2021
 **/
class TopUserRepository(
    private val topPlugin: TopPlugin,
) {

    private val topUsers = HashMap<UUID, TopUser>()

    fun addUser(topUser: TopUser) {
        topUsers[topUser.uniqueId] = topUser
    }

    fun findUser(player: Player) {
        findUser(player.uniqueId)
    }

    private fun findUser(uniqueId: UUID): Option<TopUser> =
        topUsers[uniqueId].option()
}