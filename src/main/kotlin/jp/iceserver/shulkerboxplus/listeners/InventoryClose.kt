package jp.iceserver.shulkerboxplus.listeners

import org.bukkit.block.ShulkerBox
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.meta.BlockStateMeta

class InventoryClose : Listener
{
    /**
     * シュルカーボックスを閉じた際に、アイテムを全て反映。
     */
    @EventHandler
    fun onInventoryClose(e: InventoryCloseEvent)
    {
        val player = e.player

        if (e.inventory.type != InventoryType.SHULKER_BOX) return
        if (!player.inventory.itemInMainHand.type.name.contains("SHULKER_BOX")) return

        val item = player.inventory.itemInMainHand
        val meta = item.itemMeta as BlockStateMeta
        val shulkerBox = meta.blockState as ShulkerBox

        shulkerBox.inventory.contents = e.inventory.contents
        shulkerBox.update()

        meta.blockState = shulkerBox
        item.itemMeta = meta

        player.inventory.remove(e.player.inventory.itemInMainHand)
        player.inventory.setItemInMainHand(item)
    }
}