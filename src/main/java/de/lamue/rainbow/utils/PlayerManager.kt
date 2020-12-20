package de.lamue.rainbow.utils

import org.bukkit.entity.Player

object PlayerManager {

    var playerTypes : HashMap<Player, PlayerType> = HashMap()
    var defenders : ArrayList<Player> = ArrayList()
    var attackers : ArrayList<Player> = ArrayList()
    var spectators : ArrayList<Player> = ArrayList()
    var choosings : ArrayList<Player> = ArrayList()

    fun setPlayerType(player: Player, playerType: PlayerType){
        if(playerTypes.containsKey(player)){
            playerTypes.remove(player)
        }
        playerTypes.put(player, playerType)
    }

    fun getPlayerType(player: Player): PlayerType {
        if(defenders.contains(player)) return PlayerType.DEFENDER
        if(attackers.contains(player)) return PlayerType.ATTACKER
        if(spectators.contains(player)) return PlayerType.SPECTATOR
        if(choosings.contains(player)) return PlayerType.CHOOSING
        return PlayerType.WAITING
    }

    fun getPlayerChatName(player: Player): String {
        if(player.hasPermission("r6s.prefix.red")){
            return "§4${player.name}"
        }
        return "§8${player.name}"
    }

}