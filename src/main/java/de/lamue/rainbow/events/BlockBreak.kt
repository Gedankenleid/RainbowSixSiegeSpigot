package de.lamue.rainbow.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

object BlockBreak : Listener {

    @EventHandler
    fun onBreak(event: BlockBreakEvent){
        event.isCancelled = true
    }

}