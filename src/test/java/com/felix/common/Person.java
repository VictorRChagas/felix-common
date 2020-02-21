package com.felix.common;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Person implements Serializable {

    private Integer id;
    private String name;
    private Phone phone;

    public Person() {

    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Integer id, String name, Phone phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public String getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

}
