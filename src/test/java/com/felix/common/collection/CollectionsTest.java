package com.felix.common.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionsTest {

    @Test
    void isNullOrEmptyTest() {
        assertTrue(Collections.isNullOrEmpty(new ArrayList()));
        assertTrue(Collections.isNullOrEmpty(null));
        assertTrue(Collections.isNullOrEmpty(new HashSet()));
        assertFalse(Collections.isNullOrEmpty(Arrays.asList(1, 2, 3)));
    }

}
