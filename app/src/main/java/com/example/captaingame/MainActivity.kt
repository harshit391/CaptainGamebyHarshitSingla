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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChooseDifficulty(-1)
                }
            }
        }
    }

    @Composable
    fun ChooseDifficulty(d: Int){
        var difficulty by remember { mutableIntStateOf(d) }
        if (difficulty == -1) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = {difficulty = 1}, modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Text("Easy")
                }
                Button(
                    onClick = { difficulty = 2 }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Text("Medium")
                }
                Button(
                    onClick = { difficulty = 3 }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Text("Hard")
                }
            }
        } else {
            when (difficulty) {
                1 -> CaptainGame(10000,500,1500)
                2 -> CaptainGame(10000,2000,3000)
                3 -> CaptainGame(10000,3500,4500)
                else -> {}
            }
        }
    }

    @Composable
    fun Result(found: Int, diff: Int) {
        var reset by remember {
            mutableStateOf(false)
        }

        val myStyle = TextStyle(
            fontSize = 40.sp,
        )

        var difficult by remember {
            mutableStateOf("Easy")
        }

        if (diff == 2000) {
            difficult = "Medium"
        }

        if (diff == 3500) {
            difficult = "Hard"
        }

        if (!reset) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Game Over!\n Ship's health is critically low.",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = myStyle
                    )
                    Text(
                        modifier = Modifier.padding(vertical = 32.dp),
                        text = "Game Difficulty :- $difficult",
                        color = Color.Green,
                        textAlign = TextAlign.Center,
                        style = myStyle
                    )
                    Text(
                        modifier = Modifier.padding(vertical = 32.dp),
                        text = "Treasure Found: $found",
                        color = Color.Yellow,
                        textAlign = TextAlign.Center,
                        style = myStyle
                    )
                    Button(onClick = { reset = true }, modifier = Modifier.height(64.dp).width(120.dp)) {
                        Text("Reset", fontSize = 24.sp)
                    }
                }
            }
        } else {
            ChooseDifficulty(-1)
        }
    }

    @Composable
    fun CaptainGame(xP: Int, fromRange: Int, toRange: Int) {
        var shipXP by remember {
            mutableIntStateOf(xP)
        }

        var treasuresFound by remember {
            mutableIntStateOf(0)
        }

        val direction = remember {
            mutableStateOf("North")
        }

        val stormOrTreasure = remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            if (shipXP > 100) {

                Text(text = "Treasures Found: $treasuresFound")
                Text(text = "Current Direction: ${direction.value}")
                Text(text = "Health of Ship :- $shipXP")
                Text(text = stormOrTreasure.value)

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    direction.value = "East"
                    val generate = Random.nextInt(fromRange,toRange)
                    if (generate%2==0) {
                        treasuresFound += 1
                        stormOrTreasure.value = "Found a Treasure!"
                    } else {
                        val destroyed = Random.nextInt(fromRange, toRange)
                        shipXP -= destroyed
                        stormOrTreasure.value = "Storm Ahead!"
                    }
                }) {
                    Text("Sail East")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    direction.value = "West"
                    val generate = Random.nextInt(fromRange,toRange)
                    if (generate%2==0) {
                        treasuresFound += 1
                        stormOrTreasure.value = "Found a Treasure!"
                    } else {
                        val destroyed = Random.nextInt(fromRange, toRange)
                        shipXP -= destroyed
                        stormOrTreasure.value = "Storm Ahead!"
                    }
                }) {
                    Text("Sail West")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    direction.value = "South"
                    val generate = Random.nextInt(fromRange,toRange)
                    if (generate%2==0) {
                        treasuresFound += 1
                        stormOrTreasure.value = "Found a Treasure!"
                    } else {
                        val destroyed = Random.nextInt(fromRange, toRange)
                        shipXP -= destroyed
                        stormOrTreasure.value = "Storm Ahead!"
                    }
                }) {
                    Text("Sail South")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    direction.value = "North"
                    val generate = Random.nextInt(fromRange,toRange)
                    if (generate%2==0) {
                        treasuresFound += 1
                        stormOrTreasure.value = "Found a Treasure!"
                    } else {
                        val destroyed = Random.nextInt(fromRange, toRange)
                        shipXP -= destroyed
                        stormOrTreasure.value = "Storm Ahead!"
                    }
                }) {
                    Text("Sail North")
                }
            } else {
                Result(treasuresFound,fromRange)
            }
        }
    }
}
