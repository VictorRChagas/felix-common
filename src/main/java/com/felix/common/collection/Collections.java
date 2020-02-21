package com.felix.common.collection;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public class Collections {

    public static boolean isNullOrEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }

    public static <T> boolean anyMatch(Collection<T> c, Predicate<T> predicate) {
        Objects.requireNonNull(c);

        return c.stream().anyMatch(predicate);
    }
}
