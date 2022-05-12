package com.example.chaotica

enum class Die(val size: Int, val faces: List<Int>) {
  D4(4, listOf(1, 2, 3, 4)),
  D6(6, listOf(1, 2, 3, 4, 5, 6)),
  D8(8, listOf(1, 2, 3, 4, 5, 6, 7, 8)),
  D10(10, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
  Dpc(10, listOf(0, 10, 20, 30, 40, 50, 60, 70, 80, 90)),
  D12(12, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)),
  D20(20, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
}

class DieResult(result: Int, dice: Die)

class DicePool(dice: List<Die>)

class ResultPool(results: List<DieResult>, sum: Int) {
  //    val sum = results.reduce{acc, result -> acc + result}
}
