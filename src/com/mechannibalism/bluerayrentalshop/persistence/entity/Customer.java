package com.mechannibalism.bluerayrentalshop.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final int customerId;
    private final List<BluRayDisc> rentedDiscs = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String username;  // Логін
    private String password;  // Пароль
    private String phoneNumber;

    // Конструктор
    public Customer(int customerId, String firstName, String lastName, String username,
        String password, String phoneNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Геттери та сеттери
    public int getCustomerId() {
        return customerId;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BluRayDisc> getRentedDiscs() {
        return rentedDiscs;
    }

    // Метод для оренди диску

    // Метод для повернення диску


    // Метод для отримання повного імені
    public String getFullName() {
        return firstName + " " + lastName;
    }
}


