package de.lamue.rainbow.events

import de.lamue.rainbow.Rainbow
import de.lamue.rainbow.utils.*
import org.bukkit.Bukkit
import org.bukkit.GameMode
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
        var player: Player = event.player
        if(GameManager.getGameState().equals(GameState.LOBBY)){
            CountdownManager.startCountdown()
            event.joinMessage = "§a${player.name} §7hat das Spiel betreten!"
            PlayerManager.setPlayerType(player, PlayerType.WAITING)
            player.gameMode = GameMode.SURVIVAL
            Bukkit.getScheduler().scheduleSyncDelayedTask(instance, Runnable {
                player.teleport(LocationManager.spawnLocation)
            }, 1)
        }else{
            event.joinMessage = ""
            PlayerManager.setPlayerType(player, PlayerType.SPECTATOR)
            player.gameMode = GameMode.SPECTATOR
            Messages.sendMessage(player, "§7Du bist ein Spectator.")
        }
    }

}