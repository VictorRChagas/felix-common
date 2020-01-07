package com.felix.common.collection;

public class Arrays {

    public static <T> boolean contains(T[] array, T obj) {
        for (T o : array) {
            if (o.equals(obj))
                return true;
        }
        return false;
    }

    public static boolean contains(int[] array, int obj) {
        for (int o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    public static boolean contains(long[] array, long obj) {
        for (long o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    public static boolean contains(char[] array, char obj) {
        for (char o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    public static boolean contains(double[] array, double obj) {
        for (double o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    public static boolean contains(float[] array, float obj) {
        for (float o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }
}
