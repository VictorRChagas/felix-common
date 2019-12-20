package com.felix.common.validation;

public interface Validator {

    void validate() throws ValidatorException;

    default boolean isValid() {
        try {
            validate();
            return true;
        } catch (ValidatorException e) {
            return false;
        }
    }

    default void ifValid(Runnable runnable) {
        if (isValid())
            runnable.run();
    }

    default void ifNotValid(Runnable runnable) {
        if (!isValid())
            runnable.run();
    }

    default void ifValidOrElse(Runnable runnableValid, Runnable runnableFail) {
        if (isValid())
            runnableValid.run();
        else
            runnableFail.run();
    }
}
