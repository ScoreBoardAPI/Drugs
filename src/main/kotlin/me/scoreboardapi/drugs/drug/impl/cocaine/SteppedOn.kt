package me.scoreboardapi.drugs.drug.impl.cocaine

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
object SteppedOn : Drug {

    override fun getName(): String {
        return "${ChatColor.GRAY}${ChatColor.BOLD}Stepped on"
    }

    override fun getWeight(): DrugWeight {
        return DrugWeight.GRAM
    }

    override fun getEffects(): List<PotionEffect> {
        return listOf(PotionEffect(PotionEffectType.SPEED, 10 * 20, 2),
                PotionEffect(PotionEffectType.JUMP, 10 * 20, 2),
                PotionEffect(PotionEffectType.CONFUSION, 10 * 20, 3))
    }

    override fun getClass(): DrugClass {
        return DrugClass.STIMULANT
    }

    override fun getIcon(): ItemStack {
        return ItemStack(Material.SUGAR)
    }

    override fun getDoseToOverDose(): DrugWeight {
        return DrugWeight.QUARTER
    }
}