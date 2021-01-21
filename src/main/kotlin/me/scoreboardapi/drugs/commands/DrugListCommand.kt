package me.scoreboardapi.drugs.commands

import cc.fyre.stark.engine.command.Command
import me.scoreboardapi.drugs.commands.menu.DrugListMenu

import org.bukkit.entity.Player

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
object DrugListCommand {

    @Command(["drugs list"], permission = "drugs.list", description = "Gives a list of drugs in a sweet gui!")
    @JvmStatic
    fun drugsList(sender: Player) {
        DrugListMenu().openMenu(sender)
    }
}