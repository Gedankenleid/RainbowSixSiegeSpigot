package de.lamue.rainbow.events

import de.lamue.rainbow.utils.GameManager
import de.lamue.rainbow.utils.GameState
import de.lamue.rainbow.utils.InventoryManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

object InventoryClose : Listener {

    @EventHandler
    fun onClose(event: InventoryCloseEvent){
        try {
            if(GameManager.getGameState().equals(GameState.CHOOSING)){
                val player: Player = Bukkit.getPlayer(event.player.uniqueId)!!
                InventoryManager.openOperatorInventory(player)
            }
        }catch (exception: Exception){}
    }

}