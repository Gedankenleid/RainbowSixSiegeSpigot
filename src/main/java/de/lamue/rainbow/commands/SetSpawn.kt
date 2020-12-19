package de.lamue.rainbow.commands

import de.lamue.rainbow.utils.LocationManager
import de.lamue.rainbow.utils.Messages
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object SetSpawn : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player){
            val player: Player = sender
            if(player.hasPermission("r6s.setspawn")){
                val location: Location = player.getLocation()
                LocationManager.setSpawn(location)
                Messages.sendMessage(player, "§aSpawn erfolgreich gesetzt!")
                return true
            }else{
                Messages.sendMessage(player, Messages.NOPERM)
                return true
            }
        }else{
            Messages.sendMessage(sender, Messages.NOTAPLAYER)
            return true
        }
        return false
    }


}