package org.jiho.medium

/*
        첫 번쨰 로우: 0,  0 + 2 * (nr - 1), 0 + 2(nr - 1) + 2(nr - 1)
        두 번쨰 로우: 1, 1 + 2(nr - 2), 1 + 2(nr - 2) + 2(x-1), 1 + 2(nr - 2) + 2(x-1) + 2(nr - 2)
        세 번째 로우: 2, 2 + 2(nr - 3), 1 + 2(nr - 3) + 2(x-1)

        x 번쨰 로우: x-1, x-1 + 2(nr - x), x-1 + 2(nr-x) + 2(x-1), ...
        ...
        nr 번째 로우
 */
class Problem6 {
    fun convert(s: String, numRows: Int): String {
        var result = ""
        if(numRows == 1) {
            return s
        }

        for(i in (1..numRows)) {
            result += convertByRow(s, i, numRows)
        }

        return result
    }

    private fun convertByRow(s: String, row: Int, totalRows: Int): String {
        var curPos = row - 1
        var prvPos = -1

        var result = ""
        var calculateDiagonalPos = true
        while (curPos < s.length) {
            if (prvPos != curPos) {
                result += s[curPos]
            }

            prvPos = curPos
            if (calculateDiagonalPos) {
                curPos += 2 * (totalRows - row)
            } else {
                curPos += 2 * (row - 1)
            }

            calculateDiagonalPos = !calculateDiagonalPos
        }
        return result
    }
}