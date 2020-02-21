package com.felix.common.collection;

import com.felix.common.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ListsTest {

    @Test
    void mapTest() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        assertEquals(1, Lists.map(stringList, Integer::valueOf).get(0));
        assertThrows(NullPointerException.class, () -> Lists.map(stringList, null));
        assertThrows(NullPointerException.class, () -> Lists.map(null, Object::toString));
    }

    @Test
    void nullIfEmptyTest() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        Assertions.assertNotNull(Lists.nullIfEmpty(stringList));
        Assertions.assertNull(Lists.nullIfEmpty(null));
        Assertions.assertNull(Lists.nullIfEmpty(Collections.emptyList()));
    }

    @Test
    void emptyIfNullTest() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        Assertions.assertEquals("1", Lists.emptyIfNull(stringList).get(0));;
        Assertions.assertTrue(Lists.emptyIfNull(null).isEmpty());
    }


    @Test
    void groupBy() {
        List<Person> personList = Person.getPersons();
        Map<String, List<Person>> map = Lists.groupBy(personList, Person::getName);
        assertDoesNotThrow(() -> Lists.groupBy(Collections.emptyList(), Object::hashCode));
        Assertions.assertEquals(personList.get(0), map.get("Felix").get(0));
    }
}
