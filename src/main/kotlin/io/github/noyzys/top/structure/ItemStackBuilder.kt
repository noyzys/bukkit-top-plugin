package io.github.noyzys.top.structure

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/**
 * @author: noyzys on 18:22, 10.01.2021
 **/
class ItemStackBuilder(
    private val material: Material,
    private val amount: Int,
    private val data: Int,
    private val name: String,
    private val lore: List<String>
) {

    fun toBuild(): ItemMeta {
        val itemStack = ItemStack(material, amount, data.toShort())
        val itemMeta = itemStack.itemMeta

        if (name.isNotEmpty()) {
            itemMeta.displayName = name
        }

        if (lore.isNotEmpty()) {
            itemMeta.lore = lore
        }

        itemStack.itemMeta = itemMeta
        return itemMeta
    }
}