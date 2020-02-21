package com.felix.common.functional;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.felix.common.functional.UncheckedConsumer.unchecked;

public class UncheckedConsumerTest {

    @Test
    void uncheckedTest() {
        Stream.of(1, 2, 3)
                .forEach(unchecked(this::test));
    }

    public void test(Integer n) throws Exception {

    }
}
