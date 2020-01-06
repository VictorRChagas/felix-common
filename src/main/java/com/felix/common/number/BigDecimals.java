package com.felix.common.number;

import java.math.BigDecimal;

public class BigDecimals {

    public static BigDecimal zeroIfNull(BigDecimal bd) {
        return bd == null ? BigDecimal.ZERO : bd;
    }
}
