package com.felix.common.collection;

import com.felix.common.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

import static com.felix.common.collection.Collections.anyMatch;
import static com.felix.common.collection.Lists.*;
import static org.junit.jupiter.api.Assertions.*;

public class ListsTest {

    @Test
    void mapTest() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        assertEquals(1, map(stringList, Integer::valueOf).get(0));
        assertThrows(NullPointerException.class, () -> map(stringList, null));
        assertThrows(NullPointerException.class, () -> map(null, Object::toString));
    }

    @Test
    void nullIfEmptyTest() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        Assertions.assertNotNull(nullIfEmpty(stringList));
        Assertions.assertNull(nullIfEmpty(null));
        Assertions.assertNull(nullIfEmpty(Collections.emptyList()));
    }

    @Test
    void emptyIfNullTest() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        Assertions.assertEquals("1", emptyIfNull(stringList).get(0));;
        Assertions.assertTrue(emptyIfNull(null).isEmpty());
    }

    @Test
    void groupByTest() {
        List<Person> personList = Person.getPersons();
        Map<String, List<Person>> map = groupBy(personList, Person::getName);
        assertDoesNotThrow(() -> groupBy(Collections.emptyList(), Object::hashCode));
        Assertions.assertEquals(personList.get(0), map.get("Felix").get(0));
    }

    @Test
    void filterTest() {
        List<Person> persons = Person.getPersons();
        assertThrows(NullPointerException.class, () -> anyMatch(null, Objects::nonNull));
        assertEquals("Felix", filter(persons, p -> p.getName().equals("Felix")).get(0).getName());
    }

    @Test
    void sortTest() {
        List<Person> personList = Arrays.asList(new Person(3, "Felix"), new Person(2, "Ricardo"), new Person(4, "João"));
        List<Person> personListSorted = sort(personList, Person::getId);
        assertEquals(personList.get(1), personListSorted.get(0));
    }

}
