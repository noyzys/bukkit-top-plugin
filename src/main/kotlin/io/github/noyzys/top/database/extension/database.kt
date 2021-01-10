package io.github.noyzys.top.database.extension

import java.nio.ByteBuffer
import java.util.*

/**
 * @author: noyzys on 17:49, 10.01.2021
 **/
fun ByteArray.toUniqueId(): UUID =
    ByteBuffer.wrap(this).let {
        UUID(it.long, it.long)
    }

