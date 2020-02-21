package com.felix.common.collection;

import com.felix.common.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.*;

import static com.felix.common.collection.Collections.anyMatch;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionsTest {

    @Test
    void isNullOrEmptyTest() {
        assertTrue(Collections.isNullOrEmpty(new ArrayList()));
        assertTrue(Collections.isNullOrEmpty(null));
        assertTrue(Collections.isNullOrEmpty(new HashSet()));
        assertFalse(Collections.isNullOrEmpty(Arrays.asList(1, 2, 3)));
    }

    @Test
    void anyMatchTest() {
        List<Person> persons = Person.getPersons();
        assertTrue(anyMatch(persons, p -> p.getName().equals("Felix")));
        assertThrows(NullPointerException.class, () -> anyMatch(null, Objects::nonNull));
    }
}
