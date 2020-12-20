package de.lamue.rainbow.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

object BlockPlace : Listener {

    @EventHandler
    fun onPlace(event: BlockPlaceEvent){
        event.isCancelled = true
    }

}