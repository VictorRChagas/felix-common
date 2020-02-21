package com.felix.common.functional;

import java.util.function.Consumer;

@FunctionalInterface
public interface UncheckedConsumer<T, E extends Throwable> {

    void accept(T t) throws E;

    static <T, E extends Throwable> Consumer<T> unchecked(UncheckedConsumer<T, E> consumer) {
        return (t) -> {
            try {
                consumer.accept(t);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
