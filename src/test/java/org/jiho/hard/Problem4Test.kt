package org.jiho.hard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Problem4Test {

    private val problem4 = Problem4()

    @Test
    fun test1() {
        val nums1 = arrayOf(1, 2).toIntArray()
        val nums2 = arrayOf(2).toIntArray()
        val result = problem4.findMedianSortedArrays(nums1 = nums1, nums2 = nums2)
        assertEquals(2.0, result)
    }

    @Test
    fun test2() {
        val nums1 = arrayOf(1, 2).toIntArray()
        val nums2 = arrayOf(3, 4).toIntArray()
        val result = problem4.findMedianSortedArrays(nums1 = nums1, nums2 = nums2)
        assertEquals(2.5, result)
    }

    @Test
    fun test3() {
        val nums1 = arrayOf(2,2,4,4).toIntArray()
        val nums2 = arrayOf(2,2,2,4,4).toIntArray()
        val result = problem4.findMedianSortedArrays(nums1 = nums1, nums2 = nums2)
        assertEquals(2.0, result)
    }
}