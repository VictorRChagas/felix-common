package com.felix.common.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.felix.common.validation.Validations.*;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationsTest {

    @Test
    void validateTest() {
        assertThrows(ValidatorException.class,
                () -> validate(new StringMinLengthValidator("ab"), new IntegerMinValidator(0)),
                "Integer is negative.");

        assertThrows(ValidatorException.class,
                () -> validate(new StringMinLengthValidator(null), new IntegerMinValidator(0)));

        assertDoesNotThrow(() -> validate(new StringMinLengthValidator("aa")));

        assertThrows(ValidatorException.class, () -> of(new StringMinLengthValidator("ab"), new IntegerMinValidator(0))
                .validate());
    }

    @Test
    void ifValidTest() {
        new StringMinLengthValidator("a").ifValid(Assertions::fail);
        new StringMinLengthValidator("abc").ifValid(() -> {});
        of(new StringMinLengthValidator(null), new IntegerMinValidator(0))
                .ifValid(Assertions::fail);

        of(new StringMinLengthValidator("das"), new IntegerMinValidator(2))
                .ifNotValid(Assertions::fail);
    }

    @Test
    void isValidTest() {
        assertFalse(isValid(new StringMinLengthValidator(null), new IntegerMinValidator(0)));
        assertTrue(isValid(new StringMinLengthValidator("das"), new IntegerMinValidator(2)));
        assertTrue(isValid(new StringMinLengthValidator("das")));
        assertThrows(NullPointerException.class, () -> isValid(null, null));
    }

    @Test
    void ifNotValidTest() {
        new StringMinLengthValidator("aaa").ifNotValid(Assertions::fail);
        new StringMinLengthValidator("a").ifNotValid(() -> {});
        of(new StringMinLengthValidator("das"), new IntegerMinValidator(2))
                .ifNotValid(Assertions::fail);

        of(new StringMinLengthValidator("das"), new IntegerMinValidator(2))
                .ifNotValid(() -> {});
    }

    @Test
    void ifValidOrElseTest() {
        new StringMinLengthValidator("aaa").ifValidOrElse(() -> {}, Assertions::fail);
        new StringMinLengthValidator("a").ifValidOrElse(Assertions::fail, () -> {});

        of(new StringMinLengthValidator("das"), new IntegerMinValidator(2))
                .ifValidOrElse(() -> {}, Assertions::fail);

        of(new StringMinLengthValidator(""), new IntegerMinValidator(2))
                .ifValidOrElse(Assertions::fail, () -> {});
    }

}
