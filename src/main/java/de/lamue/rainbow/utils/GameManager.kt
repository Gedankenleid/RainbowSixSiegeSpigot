package de.lamue.rainbow.utils

import de.lamue.rainbow.Rainbow
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random

object GameManager {

    lateinit var instance: Rainbow
    private lateinit var gameState: GameState
    private var players: ArrayList<Player> = ArrayList()

    fun setGameState(gameState: GameState){
        this.gameState = gameState
        Messages.sendMessage(Bukkit.getConsoleSender(), "Der GameState hat sich zu ${this.gameState} verändert!")
    }

    fun getGameState(): GameState{
        return this.gameState
    }

    fun startGame(){
        setGameState(GameState.CHOOSING)
        Bukkit.getOnlinePlayers().forEach {
            PlayerManager.setPlayerType(it, PlayerType.CHOOSING)
        }
        setPlayerTeams()
        Bukkit.getOnlinePlayers().forEach {
            it.addPotionEffect(PotionEffect(PotionEffectType.BLINDNESS, 20*60*60, 999))
            it.addPotionEffect(PotionEffect(PotionEffectType.WEAKNESS, 20*60*60, 999))
            InventoryManager.openOperatorInventory(it)
            it.playSound(it.location, Sound.BLOCK_ANVIL_FALL, 3F, 3F)
        }
    }

    fun setPlayerTeams(){
        val players: Int = Bukkit.getOnlinePlayers().size
        var rest = players % 2
        var perTeam = players / 2
        var attackersAmount = perTeam+rest
        var defendersAmount = perTeam
        Bukkit.getOnlinePlayers().forEach {
            this.players.add(it)
        }
        while (attackersAmount != 0){
            attackersAmount--
            val player: Player = getRandomPlayer()
            PlayerManager.attackers.add(player)
            Messages.sendMessage(player, "§7Du bist ein §6§lAngreifer§7!")
        }
        while (defendersAmount != 0){
            defendersAmount--
            val player: Player = getRandomPlayer()
            PlayerManager.defenders.add(player)
            Messages.sendMessage(player, "§7Du bist ein §9§lVerteidiger§7!")
        }
    }

    fun getRandomPlayer(): Player {
        var currentPlayer: Player = players.get(getRandomInt(0, players.size-1))
        players.remove(currentPlayer)
        return currentPlayer
    }

    fun getRandomInt(min: Int, max: Int): Int {
        return Random.nextInt(max - min + 1) + min
    }

    fun noSence(playerType: PlayerType){
        if(playerType.equals(PlayerType.ATTACKER)){
            Bukkit.broadcastMessage("${Messages.PREFIX}§7Alle §6§lAngreifer §7haben das Spiel verlassen!")
            Bukkit.broadcastMessage(" ")
            win(PlayerType.DEFENDER)
        }else if(playerType.equals(PlayerType.DEFENDER)){
            Bukkit.broadcastMessage("${Messages.PREFIX}§7Alle §9§lVerteidiger §7haben das Spiel verlassen!")
            Bukkit.broadcastMessage(" ")
            win(PlayerType.ATTACKER)
        }
    }

    fun win(playerType: PlayerType){
        setGameState(GameState.FINISHED)
        Bukkit.getOnlinePlayers().forEach {
            it.removePotionEffect(PotionEffectType.BLINDNESS)
            it.removePotionEffect(PotionEffectType.WEAKNESS)
            it.teleport(LocationManager.getSpawn())
        }
        if(playerType.equals(PlayerType.ATTACKER)){
            Bukkit.broadcastMessage("${Messages.PREFIX}§7Die §6§lAngreifer §7haben das Spiel gewonnen!")
        }else if(playerType.equals(PlayerType.DEFENDER)){
            Bukkit.broadcastMessage("${Messages.PREFIX}§7Die §9§lVerteidiger §7haben das Spiel gewonnen!")
        }
        Bukkit.getOnlinePlayers().forEach{
            it.playSound(it.location, Sound.BLOCK_NOTE_BLOCK_BASS, 5F, 1F)
        }
        Bukkit.broadcastMessage("${Messages.PREFIX}§7Der Server startet in §e20 Sekunden §7neu!")
        Bukkit.getScheduler().scheduleSyncDelayedTask(instance, Runnable {
            Bukkit.getOnlinePlayers().forEach {
                it.kickPlayer("${Messages.PREFIX}§cDer Server startet neu!")
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(instance, Runnable {
                Bukkit.shutdown();
            }, 20)
        }, 20*20)
    }
}