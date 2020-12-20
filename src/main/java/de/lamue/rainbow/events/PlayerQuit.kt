package de.lamue.rainbow.events

import de.lamue.rainbow.utils.GameManager
import de.lamue.rainbow.utils.GameState
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

object PlayerQuit : Listener {

    @EventHandler
    fun onQuit(event: PlayerQuitEvent){
        if(GameManager.getGameState().equals(GameState.LOBBY) || GameManager.getGameState().equals(GameState.FINISHED)){
            var player : Player = event.player
            event.quitMessage = "§c${player.name} §7hat das Spiel verlassen!"
        }
    }

}