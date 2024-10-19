package org.jiho.medium;

import java.util.Arrays;

public class Problem167 {
    public int[] twoSum(int[] nums, int target) {

        for (int ni : nums) {
            int shouldFindN = target - ni;
            boolean isFound = binarySearch(nums, shouldFindN);
            if (isFound) {
                int ans1 = getIndex(nums, ni, -1);
                int ans2 = getIndex(nums, shouldFindN, ans1);
                return new int[]{ans1 + 1, ans2 + 1};
            }
        }

        return new int[]{};
    }

    public static int getIndex(int[] nums, int target, int exclude) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && i != exclude) {
                return i;
            }
        }
        return -1;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
