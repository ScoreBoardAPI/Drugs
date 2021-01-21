package me.scoreboardapi.drugs.drug

import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
interface Drug {

    fun getName(): String
    fun getWeight(): DrugWeight
    fun getEffects(): List<PotionEffect>
    fun getDescription(): List<String> {
        return arrayListOf(
                "&7&m--------------------------",
                "&4Class Type: &f${getClass().displayName}",
                "&4Effects: &f${getEffects().joinToString { it.type.name } }",
                "&4Weight: &f${getWeight().displayName}",
                "&4Overdose Weight: &f${getDoseToOverDose().displayName}",
                "&7&m--------------------------")
    }
    fun getClass(): DrugClass
    fun getIcon(): ItemStack
    fun getDoseToOverDose() : DrugWeight
}

