package me.scoreboardapi.drugs.commands.type

import cc.fyre.stark.engine.command.data.parameter.ParameterType
import me.scoreboardapi.drugs.drug.Drug
import me.scoreboardapi.drugs.drug.Drugs
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
object DrugParameterType: ParameterType<Drug?> {

    override fun transform(sender: CommandSender, source: String): Drug? {
        val drug = Drugs.getDrug(source)

        if (drug == null) {
            sender.sendMessage("${ChatColor.RED}Couldn't find the drug \"${ChatColor.WHITE}$source${ChatColor.RED}\".")
            return null
        }

        return drug
    }

    override fun tabComplete(player: Player, flags: Set<String>, source: String): List<String> {
        val completions = arrayListOf<String>()
        for (drug in Drugs.list) {
            if (ChatColor.stripColor(drug.getName()).startsWith(source, ignoreCase = true)) {
                completions.add(ChatColor.stripColor(drug.getName()))
            }
        }
        return completions
    }
}