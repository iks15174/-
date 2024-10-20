package org.jiho.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem5Test {

    private Problem5 p = new Problem5();

    @Test
    public void test1() {
        String actual = p.longestPalindrome("babad");

        Assertions.assertEquals("bab", actual);
    }

    @Test
    public void test2() {
        String actual = p.longestPalindrome("cbbd");

        Assertions.assertEquals("bb", actual);
    }

    @Test
    public void test3() {
        String actual = p.longestPalindrome("abb");

        Assertions.assertEquals("bb", actual);
    }

    @Test
    public void test4() {
        String actual = p.longestPalindrome("ccc");

        Assertions.assertEquals("ccc", actual);
    }

    @Test
    public void test5() {
        String actual = p.longestPalindrome("aaaaa");

        Assertions.assertEquals("aaaaa", actual);
    }
}