package com.felix.common.collection;

import com.felix.common.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.*;

import static com.felix.common.collection.Collections.anyMatch;
import static com.felix.common.collection.Collections.distinctBy;
import static com.felix.common.collection.Lists.filter;
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

    @Test
    void distinctByTest() {
        List<Person> persons = Arrays.asList(
                new Person(1, "Felix"),
                new Person(2, "Felix"),
                new Person(3, "Ricardo"));

        List<Person> collect = filter(persons, distinctBy(Person::getName));
        Assertions.assertEquals(2, collect.size());
    }
}
