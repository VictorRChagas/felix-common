package com.felix.common.bool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleansTest {

    @Test
    void falseIfNullTest() {
        Boolean b1 = null;
        Boolean b2 = Boolean.FALSE;
        Boolean b3 = Boolean.TRUE;
        assertFalse(Booleans.falseIfNull(b1));
        assertFalse(Booleans.falseIfNull(b2));
        assertTrue(Booleans.falseIfNull(b3));
    }
}
