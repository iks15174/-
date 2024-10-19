package org.jiho.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1Test {

    private Problem1 p = new Problem1();

    @Test
    public void test1() {
        int[] actual = p.twoSum(new int[]{2, 7, 11, 15}, 9);

        Assertions.assertArrayEquals(new int[]{0, 1}, actual);
    }

    @Test
    public void test3() {
        int[] actual = p.twoSum(new int[]{3, 3}, 6);

        Assertions.assertArrayEquals(new int[]{0, 1}, actual);
    }

}