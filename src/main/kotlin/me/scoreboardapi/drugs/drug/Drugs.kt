package me.scoreboardapi.drugs.drug

import me.scoreboardapi.drugs.drug.impl.cocaine.FishScale
import me.scoreboardapi.drugs.drug.impl.cocaine.Puro
import me.scoreboardapi.drugs.drug.impl.cocaine.SteppedOn
import me.scoreboardapi.drugs.drug.impl.weed.*
import me.scoreboardapi.drugs.drug.impl.xanax.Barz
import me.scoreboardapi.drugs.drug.impl.xanax.Football
import me.scoreboardapi.drugs.drug.impl.xanax.Peaches
import me.scoreboardapi.drugs.drug.impl.xanax.SchoolBus
import org.bukkit.ChatColor
import org.bukkit.inventory.ItemStack

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
object Drugs {
    val list: List<Drug> = listOf(FishScale, Puro, SteppedOn, Bescotti, BlueCookies, Gelato, Glue, LemonHaze, PurpleKush, Runts, Skittles, WeddingCake, Barz, Football, Peaches, SchoolBus)

    fun findDrug(item: ItemStack): Drug? {
        if (item.hasItemMeta() && item.itemMeta.hasDisplayName()) {
            for (drug in list) {
                if (drug.getIcon().type == item.type && drug.getIcon().durability == item.durability && item.itemMeta.displayName.startsWith(drug.getName())) {
                    return drug
                }
            }
        }
        return null
    }

    fun getDrug(name: String): Drug? {
        for (drug in list) {
            if (ChatColor.stripColor(drug.getName()).equals(name, ignoreCase = true)) {
                return drug
            }
        }
        return null
    }
}