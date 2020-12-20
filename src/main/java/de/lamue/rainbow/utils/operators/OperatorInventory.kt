package de.lamue.rainbow.utils.operators

import de.lamue.rainbow.utils.PlayerType
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory

object OperatorInventory {

    fun get(playerType: PlayerType): Inventory {
        lateinit var inventory: Inventory
        if(playerType.equals(PlayerType.ATTACKER)){
           inventory = Bukkit.createInventory(null, 27, "§6§lAngreifer")
        }else if(playerType.equals(PlayerType.DEFENDER)){
            inventory = Bukkit.createInventory(null, 27, "§9§lVerteidiger")
        }

        //TODO: FILL INV

        return inventory
    }

}