package com.example.chaotica

import android.util.Log

enum class Die(val size: Int, val faces: List<Int>) {
  D4(4, listOf(1, 2, 3, 4)),
  D6(6, listOf(1, 2, 3, 4, 5, 6)),
  D8(8, listOf(1, 2, 3, 4, 5, 6, 7, 8)),
  D10(10, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
  Dpc(10, listOf(0, 10, 20, 30, 40, 50, 60, 70, 80, 90)),
  D12(12, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)),
  D20(20, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)),
}

class DicePool(var dice: MutableList<Die>) {
  fun addDieToPool(die: Die) {
    Log.i("❗️", "model add die called")
    Log.i(" : : ", dice.toString())
    dice.add(die)
    Log.i(" : ❗️ : ", dice.toString())
  }
  fun removeDieFromPool(position: Int) {
    Log.i("❗️", "model remove die called")
    Log.i("position", position.toString())
    Log.i("list size", dice.size.toString())
    dice.removeAt(position)
  }
}

data class DieResult(val result: Int, val dice: Die)

class ResultPool(results: List<DieResult>, sum: Int) {
  val sum = results.fold(0) { acc: Int, dieResult: DieResult -> acc + dieResult.result }
}
