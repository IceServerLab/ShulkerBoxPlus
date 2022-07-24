package jp.iceserver.shulkerboxplus.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.ItemStack

class InventoryClick : Listener
{
    /**
     * シュルカーボックスを開いているときに、シュルカーボックスを移動できないように。
     */
    @EventHandler
    fun onInventoryClick(e: InventoryClickEvent)
    {
        if (e.inventory.type != InventoryType.SHULKER_BOX) return

        val currentItem: ItemStack = e.currentItem ?: return
        val itemInHand = (e.whoClicked as Player).inventory.itemInMainHand

        if (currentItem != itemInHand) return
        if (!currentItem.type.name.contains("SHULKER_BOX")) return
        if (!itemInHand.type.name.contains("SHULKER_BOX")) return

        e.isCancelled = true
    }
}