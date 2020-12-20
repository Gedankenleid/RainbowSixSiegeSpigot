package de.lamue.rainbow.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.FoodLevelChangeEvent

object FoodLevelChange : Listener {

    @EventHandler
    fun onFoodLevelChange(event: FoodLevelChangeEvent){
        event.isCancelled = true
    }

}