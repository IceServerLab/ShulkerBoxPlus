package jp.iceserver.shulkerboxplus

class ShulkerBoxPlus : AbstractShulkerBoxPlus()
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