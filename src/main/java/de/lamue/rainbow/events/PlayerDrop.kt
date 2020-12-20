package de.lamue.rainbow.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent

object PlayerDrop : Listener {

    @EventHandler
    fun onDrop(event: PlayerDropItemEvent){
        event.isCancelled = true
    }

}