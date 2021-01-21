package me.scoreboardapi.drugs.commands

import cc.fyre.stark.engine.command.Command
import cc.fyre.stark.engine.command.data.parameter.Param
import cc.fyre.stark.util.ItemBuilder
import me.scoreboardapi.drugs.drug.Drug
import org.bukkit.ChatColor
import org.bukkit.entity.Player

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
object DrugGiveCommand {

    @Command(["drugs give"], permission = "drugs.give", description = "Gives a player Drugs!")
    @JvmStatic
    fun drugsGive(sender: Player, @Param(name="player") target: Player, @Param(name="drug") drug: Drug) {
        val item = ItemBuilder.copyOf(drug.getIcon()).name("${drug.getName()} ${ChatColor.GRAY}(${drug.getWeight().displayName})").setLore(drug.getDescription()).build()
        target.inventory.addItem(item)
        target.updateInventory()
    }
}