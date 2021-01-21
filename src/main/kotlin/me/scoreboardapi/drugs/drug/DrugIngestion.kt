package me.scoreboardapi.drugs.drug

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
data class DrugIngestion(val drug: Drug, val weight: DrugWeight) {
    val timeStamp: Long = System.currentTimeMillis()
}