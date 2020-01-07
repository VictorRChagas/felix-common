package com.felix.common.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArraysTest {

    @Test
    void containingTest() {
        assertTrue(Arrays.containing(new String[]{"a", "b", "c"}, "a"));
        assertFalse(Arrays.containing(new String[]{"a", "b", "c"}, "d"));
        assertTrue(Arrays.containing(new Integer[]{1, 2, 3}, 1));
        assertFalse(Arrays.containing(new Integer[]{1, 2, 3}, 4));
    }

    @Test
    void containingWithIntTest() {
        assertTrue(Arrays.containing(new int[]{1, 2, 3}, 1));
        assertFalse(Arrays.containing(new int[]{1, 2, 3}, 4));
    }

    @Test
    void containingWithLongTest() {
        assertTrue(Arrays.containing(new long[]{1L, 2L, 3L}, 1L));
        assertFalse(Arrays.containing(new long[]{1L, 2L, 3L}, 4L));
    }

    @Test
    void containingWithCharTest() {
        assertTrue(Arrays.containing(new char[]{'1', '2', '3'}, '1'));
        assertFalse(Arrays.containing(new char[]{'1', '2', '3'}, '4'));
    }

    @Test
    void containingWithFloatTest() {
        assertTrue(Arrays.containing(new float[]{1.0f, 2.0f, 3.0f}, 1.0f));
        assertFalse(Arrays.containing(new float[]{1.0f, 2.0f, 3.0f}, 4.0f));
    }

    @Test
    void containingWithDoubleTest() {
        assertTrue(Arrays.containing(new double[]{1.0d, 2.0d, 3.0d}, 1.0d));
        assertFalse(Arrays.containing(new double[]{1.0d, 2.0d, 3.0d}, 4.0d));
    }


}
