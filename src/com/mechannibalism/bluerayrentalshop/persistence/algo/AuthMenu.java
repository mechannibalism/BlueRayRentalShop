package com.mechannibalism.bluerayrentalshop.persistence.algo;


import static com.mechannibalism.bluerayrentalshop.persistence.algo.AuthSystem.login;
import static com.mechannibalism.bluerayrentalshop.persistence.algo.AuthSystem.register;

import java.util.Scanner;
import resources.Colors;

public class AuthMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Colors.RED + "\n"
            + "██████╗ ██████╗            ███████╗ ██████╗ ██████╗        ██████╗ ███████╗███╗   ██╗████████╗\n"
            + "██╔══██╗██╔══██╗           ██╔════╝██╔═══██╗██╔══██╗       ██╔══██╗██╔════╝████╗  ██║╚══██╔══╝\n"
            + Colors.GREEN
            + "██████╔╝██║  ██║           █████╗  ██║   ██║██████╔╝       ██████╔╝█████╗  ██╔██╗ ██║   ██║   \n"
            + "██╔══██╗██║  ██║           ██╔══╝  ██║   ██║██╔══██╗       ██╔══██╗██╔══╝  ██║╚██╗██║   ██║   \n"
            + Colors.BLUE
            + "██████╔╝██████╔╝           ██║     ╚██████╔╝██║  ██║       ██║  ██║███████╗██║ ╚████║   ██║   \n"
            + "╚═════╝ ╚═════╝            ╚═╝      ╚═════╝ ╚═╝  ╚═╝       ╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   \n"
            + "                                                                                                   \n"
            + Colors.RESET);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Exiting Blu-ray Rental Shop. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
