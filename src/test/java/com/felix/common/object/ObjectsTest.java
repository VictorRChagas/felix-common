package com.felix.common.object;

import com.felix.common.Person;
import com.felix.common.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectsTest {

    @Test
    void hasNullTest() {
        assertTrue(Objects.hasNull(1L, "teste", null));
        assertTrue(Objects.hasNull(null));
        assertTrue(Objects.hasNull());
        assertFalse(Objects.hasNull(1L, "teste", "aaa"));
    }

    @Test
    void copyTest() {
        Person felix = new Person(1, "Felix", new Phone("46", "991142429"));
        Person felixCopy = Objects.clone(felix);

        assertNotSame(felix, felixCopy);
        assertNotSame(felix.getPhone(), felixCopy.getPhone());
    }
}
