package com.felix.common.object;

public class Objects {

    public static boolean hasNull(Object... objects) {
        if (objects == null || objects.length == 0)
            return true;

        for (Object object : objects) {
            if (object == null)
                return true;
        }

        return false;
    }
}
