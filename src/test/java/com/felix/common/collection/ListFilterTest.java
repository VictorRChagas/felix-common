package com.felix.common.collection;

import com.felix.common.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListFilterTest {

    @Test
    void nextTest() {
        List<Person> list = Arrays.asList(new Person(1, "Felix"),
                new Person(2, "Ricardo"));

        ListFilter<Person, Integer> listFilter = ListFilter.of(list)
                .compareWith(Person::getId);

        Optional<Person> next = listFilter.next(1);

        System.out.println(next.get());
    }
}
