package de.lamue.rainbow.utils

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

object Messages {

    val PREFIX: String = "§6§lR6S §7> §f"

    val NOPERM: String = "§cDu hast nicht die benötigten Rechte!"
    val NOTAPLAYER: String = "§cDu musst ein Spieler sein um dies auszuführen!"

    fun sendMessage(sender: CommandSender, message: String){
        if(sender is ConsoleCommandSender){
            Bukkit.getConsoleSender().sendMessage("$PREFIX$message")
        }else{
            sender.sendMessage("$PREFIX$message")
        }
    }

    fun sendMessage(sender: Player, message: String){
        if(sender is ConsoleCommandSender){
            Bukkit.getConsoleSender().sendMessage("$PREFIX$message")
        }else{
            sender.sendMessage("$PREFIX$message")
        }
    }



}