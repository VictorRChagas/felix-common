package com.felix.common.collection;

import com.felix.common.People;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListFilterTest {

    @Test
    void nextTest() {
        List<People> list = Arrays.asList(new People(1, "Felix"),
                new People(2, "Ricardo"));

        ListFilter<People, Integer> listFilter = ListFilter.of(list)
                .compareWith(People::getId);

        Optional<People> next = listFilter.next(1);

        System.out.println(next.get());
    }
}
