package com.felix.common.number;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BigDecimalsTest {

    @Test
    void zeroIfNullTest() {
        assertEquals(new BigDecimal(1), BigDecimals.zeroIfNull(BigDecimal.valueOf(1)));
        assertEquals(new BigDecimal(0), BigDecimals.zeroIfNull(null));
    }

    @Test
    void nullIfZeroTest() {
        assertEquals(new BigDecimal(1), BigDecimals.nullIfZero(BigDecimal.valueOf(1)));
        assertNull(BigDecimals.nullIfZero(BigDecimal.valueOf(0)));
        assertNull(BigDecimals.nullIfZero(null));
    }
}
