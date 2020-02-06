package com.felix.common.collection;

import java.util.Collection;
import java.util.List;
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
}
