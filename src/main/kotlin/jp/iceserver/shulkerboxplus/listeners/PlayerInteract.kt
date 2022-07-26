package jp.iceserver.shulkerboxplus.listeners

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.ShulkerBox
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BlockStateMeta

class PlayerInteract : Listener
{
    /**
     * シュルカーボックスを持って右クリックをするとそのシュルカーボックスの中身をいじれるように。
     */
    @EventHandler
    fun onPlayerInteract(e: PlayerInteractEvent)
    {
        val item: ItemStack = e.item ?: return
        if (!item.type.name.contains("SHULKER_BOX")) return
        if ((e.clickedBlock ?: e.player.location.block).type.name.contains("SHULKER_BOX"))
        {
            e.isCancelled = true
            return
        }
        if (e.action != Action.RIGHT_CLICK_AIR) return

        e.player.openInventory(((item.itemMeta as BlockStateMeta).blockState as ShulkerBox).inventory)
    }
}