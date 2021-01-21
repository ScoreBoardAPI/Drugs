package me.scoreboardapi.drugs.drug.impl.xanax

import me.scoreboardapi.drugs.drug.Drug
import me.scoreboardapi.drugs.drug.DrugClass
import me.scoreboardapi.drugs.drug.DrugWeight
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
object SchoolBus: Drug {

    override fun getName(): String {
        return "${ChatColor.YELLOW}School Bus"
    }

    override fun getWeight(): DrugWeight {
        return DrugWeight.TWOMILLIGRAM
    }

    override fun getEffects(): List<PotionEffect> {
        return listOf(PotionEffect(PotionEffectType.SLOW, 10 * 20, 4),
                PotionEffect(PotionEffectType.CONFUSION, 10 * 20, 4))
    }

    override fun getClass(): DrugClass {
        return DrugClass.BENZODIAZEPINES
    }

    override fun getIcon(): ItemStack {
        return ItemStack(Material.GOLD_BLOCK)
    }

    override fun getDoseToOverDose(): DrugWeight {
        return DrugWeight.TENMILLIGRAM
    }
}