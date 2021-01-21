package me.scoreboardapi.drugs.drug.impl.weed

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
object Bescotti: Drug {

    override fun getName(): String {
        return "${ChatColor.DARK_GREEN}Bescotti"
    }

    override fun getWeight(): DrugWeight {
        return DrugWeight.GRAM
    }

    override fun getEffects(): List<PotionEffect> {
        return listOf(PotionEffect(PotionEffectType.SLOW, 10 * 20, 2),
                PotionEffect(PotionEffectType.CONFUSION, 10 * 20, 2))
    }

    override fun getClass(): DrugClass {
        return DrugClass.CANNABINOID
    }

    override fun getIcon(): ItemStack {
        return ItemStack(Material.SPECKLED_MELON)
    }

    override fun getDoseToOverDose(): DrugWeight {
        return DrugWeight.BRICK
    }
}