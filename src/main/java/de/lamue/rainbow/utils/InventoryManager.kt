package de.lamue.rainbow.utils

import de.lamue.rainbow.utils.operators.OperatorInventory
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

object InventoryManager {

    var inventories: HashMap<Player, Inventory> = HashMap()

    fun openOperatorInventory(player: Player){
        if(inventories.containsKey(player)){
            val inventory: Inventory = inventories.get(player)!!
            player.openInventory(inventory)
        }else{
            val playerType: PlayerType = PlayerManager.getPlayerType(player)
            val inventory: Inventory = OperatorInventory.get(playerType)
            inventories.put(player, inventory)
            player.openInventory(inventory)
        }
    }

}