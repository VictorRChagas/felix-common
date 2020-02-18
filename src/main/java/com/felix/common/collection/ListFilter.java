package com.felix.common.collection;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ListFilter<T, S> {

    private final List<T> list;
    private Function<T, S> compareFunction;

    private ListFilter(List<T> list) {
        this.list = list;
    }

    private ListFilter(List<T> list, Function<T, S> compareFunction) {
        this.list = list;
        this.compareFunction = compareFunction;
    }

    public static <T> ListFilter<T, ?> of(List<T> list) {
        return new ListFilter<>(list);
    }

    public <U> ListFilter<T, U> compareWith(Function<T, U> compareFunction) {
        return new ListFilter<>(this.list, compareFunction);
    }

    public Optional<T> next(S obj) {
        return list.stream()
                .filter(l -> compareFunction.apply(l).equals(obj))
                .findFirst();
    }
}
