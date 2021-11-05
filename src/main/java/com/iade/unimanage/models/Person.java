package com.iade.unimanage.models;

import java.time.LocalDate;

public abstract class Person {
    protected String name;
    protected LocalDate birthDate;
    protected String email;
    protected char gender;

    public Person(String name, LocalDate birthDate, char gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = "";
        this.gender = gender;
    }

    public abstract String getReference();

    public abstract String getName();
}
