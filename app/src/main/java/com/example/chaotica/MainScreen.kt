package com.example.chaotica

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
  val dicePool = DicePool(mutableListOf())
  val resultPool = ResultPool(mutableListOf(), 0)
  var dicePoolState by remember { mutableStateOf(dicePool) }
  var resultPoolState by remember { mutableStateOf(resultPool) }

  Column {
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
        text = "Current set: standard RPG 7-set")
    Row {
      Die.values().forEach { it ->
        DieButton(it) { dicePoolState = MainViewModel().addDieToPool(it, dicePoolState) }
      }
    }

    Text(
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
        text = "Current die pool")
    Row {
      dicePoolState.dice.forEachIndexed { i, it ->
        DieButton(it) { dicePoolState = MainViewModel().removeDieFromPool(i, dicePoolState) }
      }
    }
    Row {
      Button(
          modifier = Modifier.fillMaxWidth(),
          onClick = { resultPoolState = MainViewModel().rollDicePool(dicePoolState) }) {
        Text(text = "Roll Dice")
      }
    }

    Row { Text(text = resultPoolState.results.toString()) }
  }
}

@Composable
fun DieButton(die: Die, onClick: (Die) -> Unit) {

  Button(modifier = Modifier.width(54.dp), onClick = { onClick(die) }) {
    Text(
        text =
            when (die.name) {
              "Dpc" -> "d%"
              else -> die.name.lowercase()
            })
  }
}
