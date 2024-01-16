package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModelOfMine : CustomView = viewModel()
                    ChooseDifficulty( viewModelOfMine)
                }
            }
        }
    }

    @Composable
    fun ChooseDifficulty(myView: CustomView){
        if (myView.difficultyPublic.value == -1) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = {myView.setDifficulty1()}, modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Text("Easy")
                }
                Button(
                    onClick = { myView.setDifficulty2() }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Text("Medium")
                }
                Button(
                    onClick = { myView.setDifficulty3() }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Text("Hard")
                }
            }
        } else {
            when (myView.difficultyPublic.value) {
                1 -> CaptainGame(myView,500,1500)
                2 -> CaptainGame(myView,2000,3000)
                3 -> CaptainGame(myView,3500,4500)
                else -> {}
            }
        }
    }

    @Composable
    fun Result(myView: CustomView) {
        if (!myView.resetPublic.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(8.dp),
                contentAlignment = Alignment.Center

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Game Over!\n \n Ship's health is critically low.",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp
                    )
                    Text(
                        modifier = Modifier.padding(vertical = 32.dp),
                        text = "Game Difficulty :- ${myView.difficultPublic.value}",
                        color = Color.Green,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp
                    )
                    Text(
                        modifier = Modifier.padding(vertical = 32.dp),
                        text = "Treasure Found: ${myView.treasureFoundPublic.value}",
                        color = Color.Yellow,
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp
                    )
                    Button(onClick = { myView.resetIt() }, modifier = Modifier
                        .height(64.dp)
                        .width(120.dp)) {
                        Text("Reset", fontSize = 24.sp)
                    }
                }
            }
        } else {
            myView.resetEverything()
            ChooseDifficulty(myView)
        }
    }

    @Composable
    fun CaptainGame(myView: CustomView, fromRange: Int, toRange: Int) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            if (myView.shipXpPublic.value > 100) {

                Text(text = "Treasures Found: ${myView.treasureFoundPublic.value}")
                Text(text = "Current Direction: ${myView.directionPublic.value}")
                Text(text = "Health of Ship :- ${myView.shipXpPublic.value}")
                Text(text = myView.stormOrTreasurePublic.value)

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    myView.setDirectionEast()
                    val generate = Random.nextInt(fromRange,toRange)
                    if (generate%2==0) {
                        myView.foundTheTreasure()
                        myView.treasure()
                    } else {
                        val destroyed = Random.nextInt(fromRange, toRange)
                        myView.decreaseShipXp(destroyed)
                        myView.storm()
                    }
                }) {
                    Text("Sail East")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    myView.setDirectionWest()
                    val generate = Random.nextInt(fromRange,toRange)
                    if (generate%2==0) {
                        myView.foundTheTreasure()
                        myView.treasure()
                    } else {
                        val destroyed = Random.nextInt(fromRange, toRange)
                        myView.decreaseShipXp(destroyed)
                        myView.storm()
                    }
                }) {
                    Text("Sail West")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    myView.setDirectionSouth()
                    val generate = Random.nextInt(fromRange,toRange)
                    if (generate%2==0) {
                        myView.foundTheTreasure()
                        myView.treasure()
                    } else {
                        val destroyed = Random.nextInt(fromRange, toRange)
                        myView.decreaseShipXp(destroyed)
                        myView.storm()
                    }
                }) {
                    Text("Sail South")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    myView.setDirectionNorth()
                    val generate = Random.nextInt(fromRange,toRange)
                    if (generate%2==0) {
                        myView.foundTheTreasure()
                        myView.treasure()
                    } else {
                        val destroyed = Random.nextInt(fromRange, toRange)
                        myView.decreaseShipXp(destroyed)
                        myView.storm()
                    }
                }) {
                    Text("Sail North")
                }
            } else {
                Result(myView)
            }
        }
    }
}
