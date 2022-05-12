package com.example.chaotica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
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
            Row { Die.values().forEach { DieButton(it, viewModel) } }
            Text(text = "Current die pool")
            Row {}
          }
        }
      }
    }
  }

  @Composable
  fun DieButton(die: Die, viewModel: ViewModel) {
    Button(onClick = {}) {
      Text(
          when (die.name) {
            "Dpc" -> "d%"
            else -> die.name.lowercase()
          })
    }
  }
}
