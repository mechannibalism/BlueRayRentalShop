package com.mechannibalism.bluerayrentalshop.persistence.algo;

import static com.mechannibalism.bluerayrentalshop.persistence.algo.AuthSystem.login;
import static com.mechannibalism.bluerayrentalshop.persistence.algo.AuthSystem.register;

import java.util.Scanner;

public class ErrorHandler {

    private static void handleLoginError(String username) {
        System.out.println("1. Try again");
        System.out.println("2. Register");
        System.out.print("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Очищення буфера

        switch (choice) {
            case 1:
                login(); // Повторне введення
                break;
            case 2:
                System.out.println("Exiting to registration screen. See you soon!");
                register(); // Реєстрація
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
                break;
        }
    }
}
