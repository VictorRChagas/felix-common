package com.felix.common.bool;

public class BooleanBuilder {

    private boolean valid;

    public BooleanBuilder() {
        this(true);
    }

    public BooleanBuilder(boolean condition) {
        this.valid = condition;
    }

    public BooleanBuilder add(boolean condition) {
        if (!condition && valid)
            this.valid = false;

        return this;
    }

    public void reset() {
        this.valid = true;
    }

    public boolean isValid() {
        return valid;
    }

    public boolean isNotValid() {
        return !valid;
    }

}
