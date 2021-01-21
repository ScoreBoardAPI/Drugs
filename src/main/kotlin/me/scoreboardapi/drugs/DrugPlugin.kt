package me.scoreboardapi.drugs

import cc.fyre.stark.Stark
import me.scoreboardapi.drugs.commands.type.DrugParameterType
import me.scoreboardapi.drugs.drug.Drug
import me.scoreboardapi.drugs.listeners.DrugListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
class DrugPlugin : JavaPlugin() {

    override fun onEnable() {
        instance = this

        registerListeners()
        Stark.instance.commandHandler.registerAll(this)
        Stark.instance.commandHandler.registerParameterType(Drug::class.java, DrugParameterType)
    }

    companion object {
        lateinit var instance: DrugPlugin
    }

    private fun registerListeners() {
        Bukkit.getPluginManager().registerEvents(DrugListener(), this)
    }
}