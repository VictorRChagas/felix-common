package com.felix.common.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListsTest {

    @Test
    void mapTest() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        assertEquals(1, Lists.map(stringList, Integer::valueOf).get(0));
        assertThrows(NullPointerException.class, () -> Lists.map(stringList, null));
        assertThrows(NullPointerException.class, () -> Lists.map(null, Object::toString));
    }
}
