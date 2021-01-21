package me.scoreboardapi.drugs.drug

/**
 * Created by DaddyDombo daddydombo@gmail.com on 4/23/2020.
 */
enum class DrugWeight(val displayName: String, val numberDisplay: Double) {

    TENMICROGRAM("10 Microgram", 0.00001),
    ONEHUNDREDMICROGRAMS("100 Microgram", 0.0001),
    HALFMILLIGRAM("0.5 Milligram", 0.0005),
    MILLIGRAM("1 Milligram", 0.001),
    TWOMILLIGRAM("2 Milligram", 0.002),
    FIVEMILLIGRAM("5 Milligram", 0.005),
    TENMILLIGRAM("10 Milligram", 0.01),
    TWNETYMILLIGRAM("20 Milligram", 0.02),
    TWENTYFIVEMILLIGRAM("25 Milligram", 0.025),
    THIRTYMILLIGRAM("30 Milligram", 0.03),
    FOURTYMILLIGRAM("40 Milligram", 0.04),
    FIFTYMILLIGRAM("50 Milligram", 0.05),
    SIXTYMILLIGRAM("60 Milligram", 0.06),
    SEVENTYMILLIGRAM("70 Milligram", 0.07),
    GRAM("Gram", 1.0),
    TWOGRAM("Two Gram", 2.0),
    EIGHTH("Eighth", 3.5),
    QUARTER("Quarter", 7.0),
    HALFOUNCE("Half Ounce", 14.0),
    OUNCE("Ounce", 28.0),
    QUARTERPOUND("Quarter Pound", 112.0),
    HALFPOUND("Half Pound", 224.0),
    POUND("Pound", 448.0),
    BRICK("Brick", 1000.0)

}