package io.github.noyzys.top.structure.top.repository

import io.github.noyzys.top.TopPlugin
import io.github.noyzys.top.structure.top.comparator.PlayerKillsTopComparator

/**
 * @author: noyzys on 19:40, 10.01.2021
 **/
class TopRepository(
    private val topPlugin: TopPlugin
) {

    private val topUsersKills = sortedSetOf(PlayerKillsTopComparator())
}