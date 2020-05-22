package com.felix.common.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {

    @Test
    void returnZeroIfNullValue() {
        Number number = null;
        assertEquals(0, Numbers.zeroIfNull(number));
    }

    @Test
    void returnValueIfNotNull() {
        Number number = 15;
        assertEquals(15, Numbers.zeroIfNull(number));
    }

}
