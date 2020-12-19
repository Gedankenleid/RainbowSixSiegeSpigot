package de.lamue.rainbow.utils

import org.bukkit.Bukkit

object GameManager {

    private lateinit var gameState: GameState

    fun setGameState(gameState: GameState){
        this.gameState = gameState
        Messages.sendMessage(Bukkit.getConsoleSender(), "Der GameState hat sich zu ${this.gameState} verändert!")
    }

    fun getGameState(): GameState{
        return this.gameState
    }

}