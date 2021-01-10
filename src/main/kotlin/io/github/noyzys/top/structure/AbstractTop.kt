package io.github.noyzys.top.structure

import io.github.noyzys.top.structure.user.TopUser
import org.bukkit.Bukkit
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import kotlin.reflect.KClass
import kotlin.time.ExperimentalTime

/**
 * @author: noyzys on 17:29, 10.01.2021
 **/
abstract class AbstractTop<in T>(
    private val topName: String,
    private val topLore: String,
    private val icon: ItemStack,
    private val user: KClass<TopUser>,
    private val slot: Int
) {

    @ExperimentalTime
    abstract fun format(value: T)

    private fun buildTopItem(): ItemMeta {
        val item = ItemStackBuilder(icon.type, 1, 0, topName, arrayListOf("$topLore $user"))
        val topInventory = Bukkit.createInventory(null, 27, "Tops").apply { setItem(slot, item.toBuild() + "") }
        return item.toBuild()
    }
}
