package pl.zsl.androidapp.form;

import java.time.LocalDate;

public class Person {
    private final String name;
    private final String address;
    private final String email;
    private final LocalDate birth;
    private final String phone;

    public Person(String name, String address, String email, LocalDate birth, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birth = birth;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getPhone() {
        return phone;
    }
}
