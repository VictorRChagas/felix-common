package com.felix.common.validation;

public class Validators {

    private final Validator[] validators;

    private Validators(Validator[] validators) {
        this.validators = validators;
    }

    public static Validators of(Validator... validators) {
        return new Validators(validators);
    }

    public void validate() {
        for (Validator validator : validators) {
            validator.validate();
        }
    }

    public static void validate(Validator... validators) {
        for (Validator validator : validators) {
            validator.validate();
        }
    }

    public boolean isValid() {
        for (Validator validator : validators) {
            if (!validator.isValid())
                return false;
        }
        return true;
    }

    public static boolean isValid(Validator... validators) {
        for (Validator validator : validators) {
            if (!validator.isValid())
                return false;
        }
        return true;
    }

    public void ifValid(Runnable runnable) {
        if (isValid())
            runnable.run();
    }

    public void ifNotValid(Runnable runnable) {
        if (!isValid())
            runnable.run();
    }

    public void ifValidOrElse(Runnable runnableValid, Runnable runnableFail) {
        if (isValid())
            runnableValid.run();
        else
            runnableFail.run();
    }
}
