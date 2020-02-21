package com.felix.common.functional;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.felix.common.functional.UncheckedFunction.unchecked;

public class UncheckedFunctionTest {

    @Test
    void uncheckedTest() {
        Stream.of(1, 2, 3).map(unchecked(this::test));
    }

    public String test(Integer n) throws Exception {
        return n.toString();
    }
}
