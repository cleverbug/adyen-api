package com.github.woki.payments.adyen.model;

import static io.advantageous.boon.json.JsonFactory.toJson;

import java.io.Serializable;

@SuppressWarnings("serial, unused")
public class Name implements Serializable {
    private String firstName;
    private String lastName;
    private GenderType gender = GenderType.U;
    private String infix;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
