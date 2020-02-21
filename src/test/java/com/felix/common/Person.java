package com.felix.common;

import java.util.Arrays;
import java.util.List;

public class Person {

    private Integer id;
    private String name;

    public Person() {

    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static List<Person> getPersons() {
        return Arrays.asList(
                new Person(1, "Felix"),
                new Person(2, "Ricardo"),
                new Person(3, "João"));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
