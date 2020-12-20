package de.lamue.rainbow.events

import de.lamue.rainbow.utils.GameManager
import de.lamue.rainbow.utils.GameState
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent

object EntityDamage : Listener {

    @EventHandler
    fun onPlayerDamage(event: EntityDamageEvent){
        if(!GameManager.getGameState().equals(GameState.RUNNING)){
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onEntityDamageByEntity(event: EntityDamageByEntityEvent){
        if(!GameManager.getGameState().equals(GameState.RUNNING)){
            event.isCancelled = true
        }
    }

}