package de.lamue.rainbow.utils

import de.lamue.rainbow.utils.operators.OperatorInventory
import org.bukkit.entity.Player

object InventoryManager {

    fun openOperatorInventory(player: Player){
        var playerType: PlayerType = PlayerManager.getPlayerType(player)
        player.openInventory(OperatorInventory.get(playerType))
    }


}