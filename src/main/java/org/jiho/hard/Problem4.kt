package org.jiho.hard

/*
짝수일 때는 2개를 선택하고, 홀수일 때는 1개를 선택해야 한다
중앙부터 시작한다? x, y 의 값을 찾아야 한다
이진 탐색 두번돌리면 된다

 */
class Problem4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalSize = nums1.size + nums2.size
        val targetPos = getTargetPos(totalSize)
        var result = mutableListOf<Int>()

        var left = 0
        var right = nums1.size

        while (left < right) {
            val mid = left + (right - left) / 2
            val insertMinPos = findInsertMinPosition(nums2, nums1[mid])
            val insertMaxPos = findInsertMaxPosition(nums2, nums1[mid])

            val minPosWhenMerged= insertMinPos + mid
            val maxPosWhenMerged= insertMaxPos + mid
            var range = minPosWhenMerged..maxPosWhenMerged


            if(targetPos.any{ range.contains(it) }) {
                result.add(nums1[mid])
            }

            if(maxPosWhenMerged < targetPos.max()) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        var left2 = 0
        var right2 = nums2.size

        while (left2 < right2) {
            val mid = left2 + (right2 - left2) / 2
            val insertMinPos = findInsertMinPosition(nums1, nums2[mid])
            val insertMaxPos = findInsertMaxPosition(nums1, nums2[mid])

            val minPosWhenMerged= insertMinPos + mid
            val maxPosWhenMerged= insertMaxPos + mid
            var range = minPosWhenMerged..maxPosWhenMerged


            if(targetPos.any{ range.contains(it) }) {
                result.add(nums2[mid])
            }

            if(maxPosWhenMerged < targetPos.max()) {
                left2 = mid + 1
            } else {
                right2 = mid
            }
        }

        return result.average()
    }

    private fun findInsertMinPosition(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size

        while (left < right) {
            val mid = left + (right - left) / 2

            if (arr[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }

    private fun findInsertMaxPosition(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size

        while (left < right) {
            val mid = left + (right - left) / 2

            if (arr[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }

    private fun getTargetPos(size: Int): List<Int> {
        if(size % 2 == 1)  {
            return listOf(size / 2)
        }
        return listOf(size / 2, size / 2 - 1)
    }
}