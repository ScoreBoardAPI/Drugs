package me.scoreboardapi.drugs.listeners

import cc.fyre.stark.util.CC
import me.scoreboardapi.drugs.DrugPlugin
import me.scoreboardapi.drugs.drug.DrugIngestion
import me.scoreboardapi.drugs.drug.Drugs
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.HashMap

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
class DrugListener : Listener {

    var consumed: MutableMap<UUID, MutableList<DrugIngestion>> = HashMap()

    @EventHandler
    fun onPlayerInteractEvent(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            val itemInHand = event.player.itemInHand
            if (itemInHand != null) {
                val drug = Drugs.findDrug(itemInHand)
                if (drug != null) {
                    DrugPlugin.instance.server.scheduler.runTaskLater(DrugPlugin.instance, {
                        if (event.player.itemInHand.amount > 1) {
                            event.player.itemInHand.amount = event.player.itemInHand.amount - 1
                            event.player.updateInventory()
                        } else {
                            event.player.itemInHand = null
                            event.player.updateInventory()
                        }
                    }, 10L)

                    event.player.sendMessage("${ChatColor.GRAY}You have just ingested ${drug.getName()}!")
                    event.player.addPotionEffects(drug.getEffects())
                    consumed.putIfAbsent(event.player.uniqueId, arrayListOf())

                    val ingested = consumed[event.player.uniqueId]!!
                    ingested.add(DrugIngestion(drug, drug.getWeight()))
                    val amountIngested = ingested.filter { it.drug == drug && System.currentTimeMillis() - it.timeStamp <= TimeUnit.MINUTES.toMillis(5) }.sumByDouble { drug.getWeight().numberDisplay }

                    if (drug.getDoseToOverDose().numberDisplay < amountIngested) {
                        event.player.health = 0.0
                        event.player.sendMessage(CC.translate("&7&m-----------------------------------"))
                        event.player.sendMessage("${ChatColor.DARK_RED}OVERDOSE! ${ChatColor.DARK_GRAY}${CC.UNICODE_ARROWS_RIGHT} ${ChatColor.RED}You have just ${ChatColor.DARK_RED}OVERDOSED!")
                        event.player.sendMessage(CC.translate("&7&m-----------------------------------"))
                        return
                    }
                }
            }
        }
    }
}