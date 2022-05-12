package com.example.chaotica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chaotica.ui.theme.ChaoticaTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val viewModel = MainViewModel()
    setContent {
      ChaoticaTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          Column {
            Text(text = "Current set: standard RPG 7-set")
            Row { Die.values().forEach { it -> DieButton(it) { viewModel.addDieToPool(it) } } }
            Text(text = "Current die pool")
            Row { DicePool(viewModel) }
          }
        }
      }
    }
  }
}

// @Composable fun ChaoticaStateHolder(viewModel: MainViewModel, function: () -> Unit) {
//
//  val dicePoolState = viewModel.dicePool
//  var dicePool by remember { mutableStateOf() }
// }

@Composable
fun DieButton(die: Die, onClick: (Die) -> Unit) {

  Button(onClick = { onClick(die) }) {
    Text(
        when (die.name) {
          "Dpc" -> "d%"
          else -> die.name.lowercase()
        })
  }
}

@Composable
fun DicePool(viewModel: MainViewModel) {
  viewModel.dicePool.dice.forEachIndexed { i, it ->
    DieButton(it) { viewModel.removeDieFromPool(i) }
  }
}
