package org.jiho.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Problem7Test {
    private val p = Problem7()

    @Test
    fun test1() {
        val acutal = p.reverse(1534236469)

        assertEquals(0, acutal)
    }

    @Test
    fun test2() {
        val acutal = p.reverse(123)

        assertEquals(321, acutal)
    }

    @Test
    fun test3() {
        val acutal = p.reverse(-123)

        assertEquals(-321, acutal)
    }

    @Test
    fun test4() {
        val acutal = p.reverse(-32767)

        assertEquals(-76723, acutal)
    }
}