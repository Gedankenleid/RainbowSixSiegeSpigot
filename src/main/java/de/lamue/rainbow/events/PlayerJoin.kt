package de.lamue.rainbow.events

import de.lamue.rainbow.Rainbow
import de.lamue.rainbow.utils.GameManager
import de.lamue.rainbow.utils.GameState
import de.lamue.rainbow.utils.LocationManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import java.util.*
import kotlin.concurrent.schedule

object PlayerJoin : Listener {

    lateinit var instance: Rainbow

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        if(GameManager.getGameState().equals(GameState.LOBBY)){
            var player: Player = event.player
            event.joinMessage = "§a${player.name} §7hat das Spiel betreten!"
            println(LocationManager.spawnLocation)
            Bukkit.getScheduler().scheduleSyncDelayedTask(instance, Runnable {
                player.teleport(LocationManager.spawnLocation)
            }, 1)
        }
    }

}