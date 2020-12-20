package de.lamue.rainbow.events

import de.lamue.rainbow.utils.GameManager
import de.lamue.rainbow.utils.GameState
import de.lamue.rainbow.utils.PlayerManager
import de.lamue.rainbow.utils.PlayerType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

object PlayerMove : Listener {

    @EventHandler
    fun onMove(event: PlayerMoveEvent){
        var player: Player = event.player
        if(GameManager.getGameState().equals(GameState.CHOOSING)){
            if(PlayerManager.getPlayerType(player).equals(PlayerType.CHOOSING)){
                event.isCancelled = true
            }
        }
    }

}