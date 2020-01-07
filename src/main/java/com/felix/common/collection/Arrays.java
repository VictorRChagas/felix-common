package com.felix.common.collection;

public class Arrays {

    public static <T> boolean containing(T[] array, T obj) {
        for (T o : array) {
            if (o.equals(obj))
                return true;
        }
        return false;
    }

    public static boolean containing(int[] array, int obj) {
        for (int o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    public static boolean containing(long[] array, long obj) {
        for (long o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    public static boolean containing(char[] array, char obj) {
        for (char o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    public static boolean containing(double[] array, double obj) {
        for (double o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    public static boolean containing(float[] array, float obj) {
        for (float o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }
}
