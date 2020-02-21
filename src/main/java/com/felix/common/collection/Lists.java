package com.felix.common.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class Lists {

    public static <T, S> List<T> map(Collection<S> c, Function<S, T> function) {
        requireNonNull(c);
        requireNonNull(function);

        return c.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    public static <T> List<T> nullIfEmpty(List<T> c) {
        if (c == null)
            return null;

        return c.isEmpty() ? null : c;
    }

    public static <T> List<T> emptyIfNull(List<T> c) {
        return c == null ? Collections.emptyList() : c;
    }

    public static <K, V> Map<K, List<V>> groupBy(List<V> list, Function<V, K> function) {
        requireNonNull(list);
        requireNonNull(function);
        return list.stream()
                .collect(Collectors.groupingBy(function));
    }

}
