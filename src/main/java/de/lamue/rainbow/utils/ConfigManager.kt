package de.lamue.rainbow.utils

import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

object ConfigManager {

    private val file: File = File("plugins//R6S//config.yml")
    private val dir: File = File("plugins//R6S")
    private var configuration: YamlConfiguration = YamlConfiguration.loadConfiguration(file)

    fun check(){
        try {
            if(!directoryExists()){
                file.mkdirs()
            }
            if(!configExists()){
                file.createNewFile()
            }
        }catch (exception: IOException){
            Messages.sendMessage(Bukkit.getConsoleSender(), "§cKonnte kein Verzeichnis/Datei erstellen oder Überprüfen.")
        }
    }

    fun directoryExists() : Boolean {
        return file.exists()
    }

    fun configExists() : Boolean {
        return file.exists()
    }

    fun set(path: String, value: String){
        configuration.set(path, value)
    }

    fun get(path: String): String? {
        return configuration.getString(path)
    }

    fun getDouble(path: String): Double{
        return configuration.get(path).toString().toDouble()
    }

    fun save(){
        configuration.save(file)
    }

}