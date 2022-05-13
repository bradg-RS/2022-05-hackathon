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
    dicePool.dice.forEach {
      val randomFace = (0 until it.size).random()
      val result = it.faces[randomFace]
      results.add(DieResult(result, it))
    }
    val sum = results.fold(0) { acc: Int, dieResult: DieResult -> acc + dieResult.result }
    return ResultPool(results, sum)
  }
}
