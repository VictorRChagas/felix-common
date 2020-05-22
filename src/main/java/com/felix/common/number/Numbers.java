package com.felix.common.number;

public class Numbers {

    public static Number zeroIfNull(Number value) {
        return value != null ? value : 0;
    }

}
