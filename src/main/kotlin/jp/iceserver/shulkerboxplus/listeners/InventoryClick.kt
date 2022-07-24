package jp.iceserver.shulkerboxplus.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class InventoryClick : Listener
{
    /**
     * シュルカーボックスを開いているときに、シュルカーボックスを移動できないように。
     */
    @EventHandler
    fun onInventoryClick(e: InventoryClickEvent)
    {
        if (e.currentItem != (e.whoClicked as Player).inventory.itemInMainHand) return

        e.isCancelled = true
    }
}