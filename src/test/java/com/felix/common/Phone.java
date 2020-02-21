package com.felix.common;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable {

    private String dd;
    private String phoneNumber;

    public Phone(String dd, String phoneNumber) {
        this.dd = dd;
        this.phoneNumber = phoneNumber;
    }

    public String getDd() {
        return dd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(dd, phone.dd) &&
                Objects.equals(phoneNumber, phone.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dd, phoneNumber);
    }
}
