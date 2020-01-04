package com.felix.common.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringsTest {

    @Test
    void capitalizeTest() {
        Assertions.assertEquals("Felix gilioli", Strings.capitalize("FELIX GILIOLI"));
        Assertions.assertEquals("Felix gilioli", Strings.capitalize("felix gilioli"));
    }

    @Test
    void capitalizeAllTest() {
        Assertions.assertEquals("Felix Gilioli", Strings.capitalizeAll("FELIX GILIOLI"));
        Assertions.assertEquals("Felix Gilioli", Strings.capitalizeAll("felix gilioli"));
    }
}
