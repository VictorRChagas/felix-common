package com.felix.common.object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectsTest {

    @Test
    void hasNullTest() {
        assertTrue(Objects.hasNull(1L, "teste", null));
        assertTrue(Objects.hasNull(null));
        assertTrue(Objects.hasNull());
        assertFalse(Objects.hasNull(1L, "teste", "aaa"));
    }
}
