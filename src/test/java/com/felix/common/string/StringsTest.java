package com.felix.common.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringsTest {

    @Test
    void capitalizeTest() {
        assertEquals("Felix gilioli", Strings.capitalize("FELIX GILIOLI"));
        assertEquals("Felix gilioli", Strings.capitalize("felix gilioli"));
    }

    @Test
    void capitalizeAllTest() {
        assertEquals("Felix Gilioli", Strings.capitalizeAll("FELIX GILIOLI"));
        assertEquals("Felix Gilioli", Strings.capitalizeAll("felix gilioli"));
    }

    @Test
    void formatToLikeTest() {
        assertEquals("%felix%", Strings.formatToLike("Felix"));
        assertEquals("%felix gilioli%", Strings.formatToLike("Felix Gilioli"));
        assertEquals("% %", Strings.formatToLike(" "));
        assertEquals("%%", Strings.formatToLike(""));
        assertThrows(NullPointerException.class, () -> Strings.formatToLike(null));
    }
}
