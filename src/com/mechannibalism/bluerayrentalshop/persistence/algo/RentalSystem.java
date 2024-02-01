package com.mechannibalism.bluerayrentalshop.persistence.algo;


import com.github.javafaker.Faker;
import com.mechannibalism.bluerayrentalshop.persistence.entity.BluRayDisc;
import com.mechannibalism.bluerayrentalshop.persistence.json.DiscJsonHandler;
import com.mechannibalism.bluerayrentalshop.persistence.json.MovieJsonHandler;
import java.util.List;
import java.util.Scanner;
import resources.Colors;

/*TODO: Зробити методи для усіх функцій меню, кастомізувати меню за допомогою кольорів і емодзі*/
public class RentalSystem {


    private static final MovieJsonHandler movieJsonHandler = new MovieJsonHandler();
    private static final Faker faker = new Faker();
    public static int lastDiscId = 0; // Зберігаємо лічильник як статичне поле

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print(Colors.PURPLE + "Choose an option:" + Colors.RESET);

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewDiscs();
                    break;
                case 2:
                    rentDisc();
                    break;
                case 3:
                    returnDisc();
                    break;
                case 4:
                    addDisc();
                    break;
                case 5:
                    System.out.println(Colors.YELLOW + "Logging out. See you soon!" + Colors.RESET);
                    break;
                default:
                    System.out.println(
                        Colors.RED + "Incorrect input, try again!" + Colors.RESET);
            }

        } while (choice != 5);
    }

    private static void printMenu() {
        System.out.println(Colors.PURPLE + "\n"
            + "              _                                 \n"
            + "  /\\/\\   __ _(_)_ __     /\\/\\   ___ _ __  _   _ \n" + Colors.CYAN
            + " /    \\ / _` | | '_ \\   /    \\ / _ \\ '_ \\| | | |\n" + Colors.PURPLE
            + "/ /\\/\\ \\ (_| | | | | | / /\\/\\ \\  __/ | | | |_| |\n" + Colors.CYAN
            + "\\/    \\/\\__,_|_|_| |_| \\/    \\/\\___|_| |_|\\__,_|\n"
            + "                                                \n"
            + Colors.RESET);
        System.out.println("1. Переглянути список дисків");
        System.out.println("2. Орендувати диск");
        System.out.println("3. Повернути диск");
        System.out.println("4. Додати диск");
        System.out.println("5. Вихід з системи");
    }

    private static void viewDiscs() {
        System.out.println("All Discs:");
        List<BluRayDisc> allDiscs = DiscJsonHandler.readAllDiscs();

        for (BluRayDisc disc : allDiscs) {
            System.out.println(disc);
            System.out.println("----------------------------------");
        }
    }

    private static void rentDisc() {
        // Замість цього методу вставте код для оренди диска
        System.out.println("Орендування диска");
    }

    private static void returnDisc() {
        // Замість цього методу вставте код для повернення диска
        System.out.println("Повернення диска");
    }


    public static void addDisc() {
        BluRayDisc disc = generateDisc();
        DiscJsonHandler.writeDiscToJson(disc);
    }

    private static BluRayDisc generateDisc() {
        int discId = ++lastDiscId;
        String movieTitle = faker.book().title();
        String director = faker.name().fullName();
        boolean availableForRent = true; // За замовчуванням диск доступний для оренди

        BluRayDisc disc = new BluRayDisc(discId, movieTitle, director, availableForRent);

        // Виводимо інформацію про створений диск
        System.out.println(disc);
        System.out.println("----------------------------------");

        return disc;
    }


}
