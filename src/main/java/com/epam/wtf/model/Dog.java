package com.epam.wtf.model;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String name;
    private String description;
    private short age;
    private boolean vaccine;

    public Dog() {
    }

    public Dog(String name, String description, short age, boolean vaccine) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.vaccine = vaccine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public boolean isVaccine() {
        return vaccine;
    }

    public void setVaccine(boolean vaccine) {
        this.vaccine = vaccine;
    }
}
