package com.felix.common.validation;

public class IntegerMinValidator implements Validator {

    private final Integer i;

    public IntegerMinValidator(Integer i) {
        this.i = i;
    }

    @Override
    public void validate() throws ValidatorException {
        if (i <= 0)
            throw new ValidatorException("Integer is negative.");
    }
}
