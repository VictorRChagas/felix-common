package com.felix.common.bool;

public class Booleans {

    public static Boolean falseIfNull(Boolean b) {
        return b == null ? Boolean.FALSE : b;
    }
}
