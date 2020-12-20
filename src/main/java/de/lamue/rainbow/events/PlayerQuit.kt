package de.lamue.rainbow.events

import de.lamue.rainbow.utils.GameManager
import de.lamue.rainbow.utils.GameState
import de.lamue.rainbow.utils.PlayerManager
import de.lamue.rainbow.utils.PlayerType
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

object PlayerQuit : Listener {

    @EventHandler
    fun onQuit(event: PlayerQuitEvent){
        var player : Player = event.player
        if(GameManager.getGameState().equals(GameState.LOBBY) || GameManager.getGameState().equals(GameState.FINISHED)){
            event.quitMessage = "§c${player.name} §7hat das Spiel verlassen!"
        }else{
            event.quitMessage = ""
            if(PlayerManager.attackers.contains(player)){
                PlayerManager.attackers.remove(player)
                if(PlayerManager.attackers.size == 0){
                    GameManager.noSence(PlayerType.ATTACKER)
                }
            }
            if(PlayerManager.defenders.contains(player)){
                PlayerManager.defenders.remove(player)
                if(PlayerManager.defenders.size == 0){
                    GameManager.noSence(PlayerType.DEFENDER)
                }
            }
        }
    }

}