package com.example.chaotica

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
  var dicePool: DicePool = DicePool(mutableListOf(Die.Dpc, Die.D10))
  var resultPool: ResultPool = ResultPool(mutableListOf(), 0)

  fun addDieToPool(die: Die) {
    dicePool.addDieToPool(die)
  }

  fun removeDieFromPool(position: Int) {
    dicePool.removeDieFromPool(position)
  }
  fun rollDicePool() {}
}
