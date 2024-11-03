package org.jiho.medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem6Test {

    private val p = Problem6()

    @Test
    fun test1() {
        val actual = p.convert("PAYPALISHIRING", 3)

        assertEquals("PAHNAPLSIIGYIR", actual)
    }

    @Test
    fun test2() {
        val actual = p.convert("A", 1)

        assertEquals("A", actual)
    }
}