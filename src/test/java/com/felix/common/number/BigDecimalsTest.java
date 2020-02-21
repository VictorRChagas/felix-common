package com.felix.common.number;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void truncateTest() {
        assertEquals("14.33", BigDecimals.truncate(new BigDecimal("14.333"), 2).toString());
        assertEquals("14.00", BigDecimals.truncate(new BigDecimal("14.000"), 2).toString());
        assertEquals("14.00", BigDecimals.truncate(new BigDecimal("14.00"), 2).toString());
        assertEquals("14.00", BigDecimals.truncate(new BigDecimal("14.0"), 2).toString());
        assertEquals("14.99", BigDecimals.truncate(new BigDecimal("14.999"), 2).toString());
        assertEquals("0.00", BigDecimals.truncate(new BigDecimal("0"), 2).toString());
        assertEquals("-10.00", BigDecimals.truncate(new BigDecimal("-10.001"), 2).toString());
        assertEquals("-10", BigDecimals.truncate(new BigDecimal("-10.001"), 0).toString());
        assertThrows(NullPointerException.class, () -> BigDecimals.truncate(null, 2));
    }
}
