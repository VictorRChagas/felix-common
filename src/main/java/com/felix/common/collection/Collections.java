package com.felix.common.collection;

import java.util.Collection;

public class Collections {

    public static boolean isNullOrEmpty(Collection c) {
        return c == null || c.isEmpty();
    }

}
