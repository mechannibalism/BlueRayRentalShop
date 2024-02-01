package com.mechannibalism.bluerayrentalshop.persistence.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Customer {

    private final String username;
    private final String passwordHash; // Замінено на passwordHash

    public Customer(String username, String password) {
        this.username = username;
        this.passwordHash = hashPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String enteredPassword) {
        String enteredPasswordHash = hashPassword(enteredPassword);
        return enteredPasswordHash.equals(passwordHash);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            // Перетворюємо байтовий масив у рядок шістнадцяткових символів
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
