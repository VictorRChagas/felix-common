package com.felix.common.validation;

public class StringMinLengthValidator implements Validator {

    private final String s;

    public StringMinLengthValidator(String s) {
        this.s = s;
    }

    @Override
    public void validate() throws ValidatorException {
        if (s != null && s.length() < 2)
            throw new ValidatorException("Invalid String length.");
    }

}
