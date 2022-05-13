package com.example.chaotica

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

  fun addDieToPool(die: Die, dicePool: DicePool): DicePool {
    return DicePool(dicePool.dice + die)
  }

  fun removeDieFromPool(position: Int, dicePool: DicePool): DicePool {
    return DicePool(dicePool.dice.minus(dicePool.dice[position]))
  }

  fun rollDicePool(dicePool: DicePool): ResultPool {
    val results = mutableListOf<DieResult>()
    dicePool.dice.forEachIndexed { i, it ->
      val result = (1..it.size).random()
      results[i] = DieResult(result, it)
    }
    val sum = results.fold(0) { acc: Int, dieResult: DieResult -> acc + dieResult.result }
    return ResultPool(results, sum)
  }
}
