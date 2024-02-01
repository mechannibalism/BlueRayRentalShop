package com.mechannibalism.bluerayrentalshop.persistence.algo;

public class AuthValidify {

    public static boolean isValidUsername(String username) {
        // Валідація за допомогою регулярного виразу
        String usernameRegex = "^[a-zA-Z]{4,16}$";
        return username.matches(usernameRegex);
    }

    public static boolean isValidPassword(String password) {
        // Валідація за допомогою регулярного виразу
        String passwordRegex = "^[a-zA-Z0-9]{8,24}$";
        return password.matches(passwordRegex);
    }
}
