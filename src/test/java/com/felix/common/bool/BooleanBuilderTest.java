package com.felix.common.bool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanBuilderTest {

    @Test
    void isValidTest() {
        BooleanBuilder bb = new BooleanBuilder(false)
                .add(true)
                .add(false);

        assertFalse(bb.isValid());
        assertTrue(bb.isNotValid());

        assertTrue(new BooleanBuilder().isValid());
        assertTrue(new BooleanBuilder(true).isValid());
        assertFalse(new BooleanBuilder(false).isValid());
        assertTrue(new BooleanBuilder(true).add(true).isValid());
    }

    @Test
    void resetTest() {
        BooleanBuilder bb = new BooleanBuilder(true);
        bb.reset();
        assertTrue(bb.isValid());

        bb = new BooleanBuilder(false);
        bb.reset();
        assertTrue(bb.isValid());

        bb = new BooleanBuilder(false);
        bb.reset();
        bb.add(false);
        assertFalse(bb.isValid());
    }

}
