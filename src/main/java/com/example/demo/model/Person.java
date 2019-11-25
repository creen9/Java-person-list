package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    private final int id;

    @NotBlank
    private final String name;

    @NotBlank
    private String surname;

    private String address;

    private int age;

    public Person(@JsonProperty("id") int id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname,
                  @JsonProperty("address") String address,
                  @JsonProperty("age") int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
}
