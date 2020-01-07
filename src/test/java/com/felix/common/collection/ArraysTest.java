package com.felix.common.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArraysTest {

    @Test
    void containsTest() {
        assertTrue(Arrays.contains(new String[]{"a", "b", "c"}, "a"));
        assertFalse(Arrays.contains(new String[]{"a", "b", "c"}, "d"));
        assertTrue(Arrays.contains(new Integer[]{1, 2, 3}, 1));
        assertFalse(Arrays.contains(new Integer[]{1, 2, 3}, 4));
    }

    @Test
    void containsWithIntTest() {
        assertTrue(Arrays.contains(new int[]{1, 2, 3}, 1));
        assertFalse(Arrays.contains(new int[]{1, 2, 3}, 4));
    }

    @Test
    void containsWithLongTest() {
        assertTrue(Arrays.contains(new long[]{1L, 2L, 3L}, 1L));
        assertFalse(Arrays.contains(new long[]{1L, 2L, 3L}, 4L));
    }

    @Test
    void containsWithCharTest() {
        assertTrue(Arrays.contains(new char[]{'1', '2', '3'}, '1'));
        assertFalse(Arrays.contains(new char[]{'1', '2', '3'}, '4'));
    }

    @Test
    void containsWithFloatTest() {
        assertTrue(Arrays.contains(new float[]{1.0f, 2.0f, 3.0f}, 1.0f));
        assertFalse(Arrays.contains(new float[]{1.0f, 2.0f, 3.0f}, 4.0f));
    }

    @Test
    void containsWithDoubleTest() {
        assertTrue(Arrays.contains(new double[]{1.0d, 2.0d, 3.0d}, 1.0d));
        assertFalse(Arrays.contains(new double[]{1.0d, 2.0d, 3.0d}, 4.0d));
    }


}
