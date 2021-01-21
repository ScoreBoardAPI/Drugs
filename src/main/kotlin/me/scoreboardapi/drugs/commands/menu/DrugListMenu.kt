package me.scoreboardapi.drugs.commands.menu

import cc.fyre.stark.engine.menu.Button
import cc.fyre.stark.engine.menu.pagination.PaginatedMenu
import cc.fyre.stark.util.CC
import cc.fyre.stark.util.ItemBuilder
import me.scoreboardapi.drugs.drug.Drugs
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import java.util.ArrayList
import java.util.HashMap

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
class DrugListMenu: PaginatedMenu() {

    init {
        this.updateAfterClick = true
        this.autoUpdate = true
        this.async = true
    }

    override fun getPrePaginatedTitle(player: Player): String {
        return "${ChatColor.GOLD}Drug List"
    }

    override fun getMaxItemsPerPage(player: Player): Int {
        return 27
    }

    override fun getGlobalButtons(player: Player): Map<Int, Button>? {
        return HashMap()
    }

    override fun getAllPagesButtons(player: Player): Map<Int, Button> {

        val toReturn = HashMap<Int, Button>()

        for (drug in Drugs.list) {

            toReturn[toReturn.size] = object : Button() {
                override fun getName(player: Player): String? {
                    return drug.getName()
                }

                override fun getDescription(player: Player): List<String> {
                    val toReturn = ArrayList<String>()

                    toReturn.addAll(drug.getDescription())

                    if (player.hasPermission("drugs.give")) {
                        toReturn.add("")
                        toReturn.add("${ChatColor.GRAY}Click to give yourself this drug!")
                        toReturn.add("${ChatColor.GRAY}${CC.MENU_BAR}")
                    }

                    return toReturn
                }

                override fun getMaterial(player: Player): Material {
                    return drug.getIcon().type
                }

                override fun getDamageValue(player: Player): Byte {
                    return drug.getIcon().durability.toByte()
                }

                override fun clicked(player: Player, slot: Int, clickType: ClickType) {
                    val item = ItemBuilder.copyOf(drug.getIcon()).name("${drug.getName()} ${ChatColor.GRAY}(${drug.getWeight().displayName})").setLore(drug.getDescription()).build()
                    if (player.hasPermission("drugs.give")) {
                        player.inventory.addItem(item)
                        player.updateInventory()
                    } else {
                        player.sendMessage("${ChatColor.RED}No Permission")
                    }
                }
            }
        }
        return toReturn
    }
}
