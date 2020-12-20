package de.lamue.rainbow.events

import de.lamue.rainbow.utils.*
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

object PlayerChat : Listener {

    @EventHandler
    fun onChat(event: AsyncPlayerChatEvent) {
        val player: Player = event.player
        val message: String = event.message.replace("%", "%%")
        if(GameManager.getGameState().equals(GameState.RUNNING)){
            var playerType = PlayerManager.getPlayerType(player)
            if(playerType == PlayerType.SPECTATOR){
                PlayerManager.spectators.forEach{
                    it.sendMessage("§8${player.name} §7> §e$message")
                }
                return
            }else if(playerType == PlayerType.ATTACKER){
                PlayerManager.attackers.forEach{
                    it.sendMessage("§6${player.name} §7> §e$message")
                }
                return
            }else if(playerType == PlayerType.DEFENDER){
                PlayerManager.defenders.forEach{
                    it.sendMessage("§9${player.name} §7> §e$message")
                }
                return
            }else if(playerType == PlayerType.CHOOSING){
                Messages.sendMessage(player, "§cDu kannst in dieser Phase nicht schreiben!")
                event.isCancelled = true
                return
            }
        }else if(GameManager.getGameState().equals(GameState.CHOOSING)){
            Messages.sendMessage(player, "§cDu kannst in dieser Phase nicht schreiben!")
            event.isCancelled = true
            return
        }else{
            event.format = "${PlayerManager.getPlayerChatName(player)} §7> §e$message"
        }
    }

}