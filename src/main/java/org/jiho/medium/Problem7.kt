package org.jiho.medium

class Problem7 {
    fun reverse(x: Int): Int {
        val maxVal = Int.MAX_VALUE.toString()
        val minVal = Int.MIN_VALUE.toString().substring(1)

        val strX = x.toString()
        var reversed = strX.reversed()
        if (reversed.last() == '-') {
            reversed = reversed.dropLast(1)
            reversed = "-$reversed"
        }

        if (reversed[0] == '-') {
            val withOutMinus = reversed.substring(1)
            if(withOutMinus.length > minVal.length) {
                return 0
            }

            val padded = withOutMinus.padStart(minVal.length, '0')
            if(padded > minVal) {
                return 0
            }
        }

        if (reversed[0] != '-') {
            if(reversed.length > maxVal.length) {
                return 0
            }

            val padded = reversed.padStart(maxVal.length, '0')
            if(padded > maxVal) {
                return 0
            }
        }

        return reversed.toInt()
    }
}