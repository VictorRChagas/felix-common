package com.felix.common.number;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.util.Objects.requireNonNull;

public class BigDecimals {

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public static BigDecimal zeroIfNull(BigDecimal bd) {
        return bd == null ? BigDecimal.ZERO : bd;
    }

    public static BigDecimal nullIfZero(BigDecimal bd) {
        if (bd == null)
            return null;

        return bd.compareTo(BigDecimal.ZERO) == 0 ? null : bd;
    }

    public static BigDecimal truncate(BigDecimal bd, int places) {
        requireNonNull(bd);
        return bd.setScale(places, RoundingMode.DOWN);
    }

    public static BigDecimal percent(BigDecimal value, BigDecimal percent) {
        requireNonNull(value);
        requireNonNull(percent);
        return value.multiply(percent).divide(ONE_HUNDRED);
    }

    public static BigDecimal addPercent(BigDecimal value, BigDecimal percent) {
        requireNonNull(value);
        requireNonNull(percent);
        return value.add(value.multiply(percent).divide(ONE_HUNDRED));
    }

    public static BigDecimal subtractPercent(BigDecimal value, BigDecimal percent) {
        requireNonNull(value);
        requireNonNull(percent);
        return value.subtract(value.multiply(percent).divide(ONE_HUNDRED));
    }
}
