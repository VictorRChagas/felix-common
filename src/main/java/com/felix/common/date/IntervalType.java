package com.felix.common.date;

import java.time.temporal.ChronoUnit;

public enum IntervalType {
    DAY(ChronoUnit.DAYS),
    YEAR(ChronoUnit.YEARS),
    MONTH(ChronoUnit.MONTHS);

    private ChronoUnit chrono;

    IntervalType(ChronoUnit chrono) {
        this.chrono = chrono;
    }

    public ChronoUnit getChrono() {
        return this.chrono;
    }
}
