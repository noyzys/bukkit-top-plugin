package io.github.noyzys.top.structure.user

import java.util.*

/**
 * @author: noyzys on 17:24, 10.01.2021
 **/
data class TopUser(
    val uniqueId: UUID,
    val nickName: String,
    val kills: Int,
    val killsPositions: Int
)