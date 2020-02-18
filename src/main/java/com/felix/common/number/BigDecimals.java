package com.felix.common.number;

import java.math.BigDecimal;

public class BigDecimals {

    public static BigDecimal zeroIfNull(BigDecimal bd) {
        return bd == null ? BigDecimal.ZERO : bd;
    }

    public static BigDecimal nullIfZero(BigDecimal bd) {
        if (bd == null)
            return null;

        return bd.compareTo(BigDecimal.ZERO) == 0 ? null : bd;
    }
}
