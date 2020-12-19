package de.lamue.rainbow.utils

import org.bukkit.Bukkit
import org.bukkit.Location


object LocationManager {

    lateinit var spawnLocation: Location

    fun setSpawn(location: Location){
        val cm: ConfigManager = ConfigManager
        cm.set("Spawn.X", location.x.toString())
        cm.set("Spawn.Y", (location.y+2).toString())
        cm.set("Spawn.Z", location.z.toString())
        cm.set("Spawn.Pitch", location.pitch.toString())
        cm.set("Spawn.Yaw", location.yaw.toString())
        cm.set("Spawn.World", location.world!!.name)
        cm.save()
        spawnLocation = location
    }

    fun getSpawn(): Location {
        val cm: ConfigManager = ConfigManager
        return Location(
                Bukkit.getWorld(cm.get("Spawn.World").toString()),
                cm.getDouble("Spawn.X"), cm.getDouble("Spawn.Y"), cm.getDouble("Spawn.Z"),
                cm.getDouble("Spawn.Yaw").toFloat(), cm.getDouble("Spawn.Pitch").toFloat())
    }

}