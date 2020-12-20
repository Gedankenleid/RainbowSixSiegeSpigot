package de.lamue.rainbow.utils

import de.lamue.rainbow.Rainbow
import org.bukkit.Bukkit
import org.bukkit.Sound

object CountdownManager {

    lateinit var instance: Rainbow

    val minPlayerToStart: Int = 1 //Minimum clients to start the game
    var countdownIsRunning: Boolean = false
    var currentCount: Int = 61
    var countdown: Int = 0
    val broadCastAt: Array<Int> = arrayOf(60, 45, 30, 15, 10, 5, 3, 2, 1)

    fun startCountdown(){
        if(!countdownIsRunning){
            countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, Runnable {
                if(Bukkit.getOnlinePlayers().size >= minPlayerToStart){
                    countdownIsRunning = true
                    currentCount--
                    if(broadCastAt.contains(currentCount)){
                        if(currentCount > 1){
                            Bukkit.broadcastMessage("${Messages.PREFIX}§eDas Spiel startet in §7$currentCount Sekunden§e!")
                        }else{
                            Bukkit.broadcastMessage("${Messages.PREFIX}§eDas Spiel startet in §7$currentCount Sekunde§e!")
                        }
                        Bukkit.getOnlinePlayers().forEach{
                            it.playSound(it.location, Sound.BLOCK_NOTE_BLOCK_BASS, 1F, 1F)
                        }
                    }
                    if(currentCount == 0){
                        start()
                        Bukkit.getScheduler().cancelTask(countdown)
                    }
                }else{
                    countdownIsRunning = false
                    Bukkit.getOnlinePlayers().forEach{
                        it.playSound(it.location, Sound.BLOCK_NOTE_BLOCK_BASS, 5F, 5F)
                    }
                    Bukkit.broadcastMessage("${Messages.PREFIX}§eDas Spiel startet ab §7$minPlayerToStart Spielern§e!")
                    currentCount = 61
                    Bukkit.getScheduler().cancelTask(countdown)
                }
            }, 0, 20)
        }
    }

    fun start(){
        Bukkit.broadcastMessage("${Messages.PREFIX}§eDas Spiel startet jetzt!")
        Bukkit.getOnlinePlayers().forEach{
            it.playSound(it.location, Sound.BLOCK_NOTE_BLOCK_PLING, 5F, 1F)
        }
        GameManager.setGameState(GameState.CHOOSING)
        Bukkit.getOnlinePlayers().forEach {
            PlayerManager.setPlayerType(it, PlayerType.CHOOSING)
        }
    }

}