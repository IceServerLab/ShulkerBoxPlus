package jp.iceserver.shulkerboxplus

import org.bukkit.plugin.java.JavaPlugin

class ShulkerBoxPlus : JavaPlugin()
{
    companion object
    {
        lateinit var plugin: ShulkerBoxPlus
    }

    override fun onEnable()
    {
        plugin = this
    }
}