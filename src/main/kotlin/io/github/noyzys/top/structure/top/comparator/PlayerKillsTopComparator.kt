package io.github.noyzys.top.structure.top.comparator

import com.google.common.primitives.Ints
import io.github.noyzys.top.structure.user.TopUser

/**
 * @author: noyzys on 20:01, 10.01.2021
 **/
class PlayerKillsTopComparator : Comparator<TopUser> {

    override fun compare(topUserOne: TopUser, topUserTwo: TopUser): Int {
        var compare = Ints.compare(topUserOne.kills, topUserTwo.kills)
        if (compare == 0) {
            val identifierOne = topUserOne.kills
            val identifierTwo = topUserTwo.kills

            identifierOne ?: -1
            identifierTwo ?: 1

            compare = identifierOne.compareTo(identifierTwo)
        }

        return compare
    }
}