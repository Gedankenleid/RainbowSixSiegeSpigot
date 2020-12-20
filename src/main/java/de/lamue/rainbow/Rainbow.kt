package de.lamue.rainbow

import de.lamue.rainbow.commands.SetSpawn
import de.lamue.rainbow.events.*
import de.lamue.rainbow.utils.*
import org.bukkit.Bukkit
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin

class Rainbow : JavaPlugin() {

    override fun onEnable() {
        GameManager.setGameState(GameState.LOBBY)
        PlayerJoin.instance = this
        CountdownManager.instance = this
        val pluginManager: PluginManager = Bukkit.getPluginManager()
        ConfigManager.check()

        pluginManager.registerEvents(PlayerJoin, this)
        pluginManager.registerEvents(PlayerQuit, this)
        pluginManager.registerEvents(PlayerChat, this)
        pluginManager.registerEvents(FoodLevelChange, this)
        pluginManager.registerEvents(WeatherChange, this)
        pluginManager.registerEvents(PlayerMove, this)
        pluginManager.registerEvents(PlayerDrop, this)
        pluginManager.registerEvents(EntityDamage, this)
        pluginManager.registerEvents(BlockBreak, this)
        pluginManager.registerEvents(BlockPlace, this)

        getCommand("setspawn")!!.setExecutor(SetSpawn)
        LocationManager.spawnLocation = LocationManager.getSpawn()
        Messages.sendMessage(Bukkit.getConsoleSender(), "§aPlugin gestartet!")
    }

    override fun onDisable() {
        Messages.sendMessage(Bukkit.getConsoleSender(), "§cPlugin gestoppt!")
    }
}