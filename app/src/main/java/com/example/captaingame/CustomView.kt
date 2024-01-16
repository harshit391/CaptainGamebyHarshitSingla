package com.example.captaingame

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CustomView : ViewModel() {

    private val _repository : Repo = Repo()

    private val _difficulty = mutableIntStateOf(_repository.getCaptainGameData().difficulty)
    private val _reset = mutableStateOf(_repository.getCaptainGameData().reset)
    private val _difficult = mutableStateOf(_repository.getCaptainGameData().difficult)
    private val _shipXP = mutableIntStateOf(_repository.getCaptainGameData().shipXP)

    private val _treasureFound = mutableIntStateOf(_repository.getCaptainGameData().treasureFound)
    private val _direction = mutableStateOf(_repository.getCaptainGameData().direction)
    private val _stormOrTreasure = mutableStateOf(_repository.getCaptainGameData().stormOrTreasure)

    val difficultyPublic : MutableState<Int> = _difficulty
    val resetPublic : MutableState<Boolean> = _reset
    val difficultPublic : MutableState<String> = _difficult
    val shipXpPublic : MutableState<Int> = _shipXP

    val treasureFoundPublic : MutableState<Int> = _treasureFound
    val directionPublic : MutableState<String> = _direction
    val stormOrTreasurePublic : MutableState<String> = _stormOrTreasure

    fun resetEverything() {
        _repository.resetEverything()
        _difficulty.intValue = _repository.getCaptainGameData().difficulty
        _reset.value = _repository.getCaptainGameData().reset
        _difficult.value = _repository.getCaptainGameData().difficult
        _shipXP.intValue = _repository.getCaptainGameData().shipXP
        _treasureFound.intValue = _repository.getCaptainGameData().treasureFound
        _direction.value = _repository.getCaptainGameData().direction
        _stormOrTreasure.value = _repository.getCaptainGameData().stormOrTreasure
    }
    fun setDifficulty1() {
        _repository.setDifficulty1()
        _difficulty.intValue = _repository.getCaptainGameData().difficulty
    }

    fun setDifficulty2() {
        _repository.setDifficulty2()
        _difficulty.intValue = _repository.getCaptainGameData().difficulty
    }

    fun setDifficulty3() {
        _repository.setDifficulty3()
        _difficulty.intValue = _repository.getCaptainGameData().difficulty
    }

    fun resetIt() {
        _repository.resetIt()
        _reset.value = _repository.getCaptainGameData().reset
    }


    fun setDifficult1() {
        _repository.setDifficult1()
        _difficult.value = _repository.getCaptainGameData().difficult
    }

    fun setDifficult2() {
        _repository.setDifficult2()
        _difficult.value = _repository.getCaptainGameData().difficult
    }

    fun setDifficult3() {
        _repository.setDifficult3()
        _difficult.value = _repository.getCaptainGameData().difficult
    }

    fun decreaseShipXp(value: Int) {
        _repository.decreaseShipXp(value)
        _shipXP.intValue = _repository.getCaptainGameData().shipXP
    }

    fun foundTheTreasure() {
        _repository.foundTheTreasure()
        _treasureFound.intValue = _repository.getCaptainGameData().treasureFound
    }

    fun setDirectionNorth() {
        _repository.setDirectionNorth()
        _direction.value = _repository.getCaptainGameData().direction
    }

    fun setDirectionEast() {
        _repository.setDirectionEast()
        _direction.value = _repository.getCaptainGameData().direction
    }

    fun setDirectionSouth() {
        _repository.setDirectionSouth()
        _direction.value = _repository.getCaptainGameData().direction
    }

    fun setDirectionWest() {
        _repository.setDirectionWest()
        _direction.value = _repository.getCaptainGameData().direction
    }

    fun storm() {
        _repository.storm()
        _stormOrTreasure.value = _repository.getCaptainGameData().stormOrTreasure
    }

    fun treasure() {
        _repository.treasure()
        _stormOrTreasure.value = _repository.getCaptainGameData().stormOrTreasure
    }




}