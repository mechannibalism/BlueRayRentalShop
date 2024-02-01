package com.mechannibalism.bluerayrentalshop.persistence.algo;

import static com.mechannibalism.bluerayrentalshop.persistence.algo.AuthValidify.isValidPassword;
import static com.mechannibalism.bluerayrentalshop.persistence.algo.AuthValidify.isValidUsername;
import static com.mechannibalism.bluerayrentalshop.persistence.algo.RentalSystem.mainMenu;
import static com.mechannibalism.bluerayrentalshop.persistence.json.auth.UserHandler.customers;
import static com.mechannibalism.bluerayrentalshop.persistence.json.auth.UserHandler.findCustomerByUsername;
import static com.mechannibalism.bluerayrentalshop.persistence.json.auth.UserHandler.saveCustomersToJson;

import com.mechannibalism.bluerayrentalshop.persistence.entity.Customer;
import java.util.Scanner;
import resources.Colors;

public class AuthSystem {

    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Registration ===");

        // Валідація ім'я користувача
        String username;
        do {
            System.out.print("Enter your username (4-16 Latin characters only): ");
            username = scanner.nextLine();
            if (!isValidUsername(username)) {
                System.out.println("Error! Try again.");
            }
        } while (!isValidUsername(username));

        // Валідація пароля
        String password;
        do {
            System.out.print("Enter your password (8-24 Latin letters and digits only): ");
            password = scanner.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Error! Try again.");
            }

        } while (!isValidPassword(password));

        Customer newCustomer = new Customer(username, password);
        customers.add(newCustomer);
        saveCustomersToJson();

        System.out.println("Registration successful!\n");

        login();
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Login ===");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Customer foundCustomer = findCustomerByUsername(username);

        if (foundCustomer != null && foundCustomer.authenticate(password)) {
            System.out.println(Colors.GREEN);

            mainMenu();
        } else {
            System.out.println(
                Colors.RED + "Username doesn't exist. Try again or complete registration first!"
                    + Colors.RESET);

            System.out.println("1. Try again");
            System.out.println("2. Register");
            System.out.print("Enter your choice: ");

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
}
