package jp.iceserver.shulkerboxplus

import jp.iceserver.shulkerboxplus.listeners.*

class ShulkerBoxPlus : AbstractShulkerBoxPlus()
{
    companion object
    {
        lateinit var plugin: ShulkerBoxPlus
    }

    override fun onEnable()
    {
        plugin = this

        registerListeners(
            InventoryClick(), InventoryClose(), PlayerInteract()
        )
    }
}