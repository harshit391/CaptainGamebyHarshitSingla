package com.example.captaingame

data class CaptainGameData(var difficulty:Int, var reset: Boolean, var difficult:String, var shipXP:Int,
    var treasureFound: Int, var direction:String, var stormOrTreasure:String)

class Repo{
    private var _start = CaptainGameData(
-1,false, "Easy",10000,0,"North",""
    )

    fun getCaptainGameData() = _start

    fun resetEverything() {
        _start.difficulty = -1
        _start.reset = false
        _start.difficult = "Easy"
        _start.shipXP = 10000
        _start.treasureFound = 0
        _start.direction = "North"
        _start.stormOrTreasure = ""
    }

    fun setDifficulty1() {
        _start.difficulty = 1
    }

    fun setDifficulty2() {
        _start.difficulty = 2
    }

    fun setDifficulty3() {
        _start.difficulty = 3
    }

    fun resetIt() {
        _start.reset = true
    }

    fun setDifficult1() {
        _start.difficult = "Easy"
    }

    fun setDifficult2() {
        _start.difficult = "Medium"
    }

    fun setDifficult3() {
        _start.difficult = "Hard"
    }

    fun decreaseShipXp(value: Int) {
        _start.shipXP -= value
    }

    fun foundTheTreasure() {
        _start.treasureFound++
    }

    fun setDirectionNorth() {
        _start.direction = "North"
    }

    fun setDirectionEast() {
        _start.direction = "East"
    }

    fun setDirectionSouth() {
        _start.direction = "South"
    }

    fun setDirectionWest() {
        _start.direction = "West"
    }

    fun storm() {
        _start.stormOrTreasure = "Storm Ahead !!"
    }

    fun treasure() {
        _start.stormOrTreasure = "Treasure Found !!"
    }
}