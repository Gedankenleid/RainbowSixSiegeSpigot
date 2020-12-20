package de.lamue.rainbow.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.weather.WeatherChangeEvent

object WeatherChange : Listener {

    @EventHandler
    fun onWeatherChange(event: WeatherChangeEvent){
        event.isCancelled = true
    }

}