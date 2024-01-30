package com.mechannibalism.bluerayrentalshop.persistence.algo;

import com.github.javafaker.Faker;
import com.mechannibalism.bluerayrentalshop.persistence.entity.BluRayDisc;
import com.mechannibalism.bluerayrentalshop.persistence.entity.Movie;
import com.mechannibalism.bluerayrentalshop.persistence.json.DiscJsonHandler;
import com.mechannibalism.bluerayrentalshop.persistence.json.MovieJsonHandler;
import java.util.List;
import java.util.Scanner;

/*TODO: Зробити методи для усіх функцій меню, кастомізувати меню за допомогою кольорів і емодзі*/
public class RentalSystem {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private static final MovieJsonHandler movieJsonHandler = new MovieJsonHandler();
    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print(ANSI_BLUE + "Виберіть пункт:" + ANSI_RESET);

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
                    System.out.println("Вихід з системи. До побачення!");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }

        } while (choice != 5);
    }

    private static void printMenu() {
        System.out.println("Меню вибору:");
        System.out.println("1. Переглянути список дисків");
        System.out.println("2. Орендувати диск");
        System.out.println("3. Повернути диск");
        System.out.println("4. Додати диск");
        System.out.println("5. Вихід з системи");
    }

    private static void viewDiscs() {
        // Замість цього методу вставте код для виведення інформації про диски
        System.out.println("Виведення інформації про диски");
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
        int discId = faker.number().randomDigitNotZero();
        String movieTitle = faker.book().title();
        String director = faker.name().fullName();
        boolean availableForRent = true; // За замовчуванням диск доступний для оренди

        BluRayDisc disc = new BluRayDisc(discId, movieTitle, director, availableForRent);

        // Виводимо інформацію про створений диск
        System.out.println(disc);
        System.out.println("----------------------------------");

        return disc;
    }

    private static Movie findOrCreateMovie(String movieId) {
        List<Movie> movies = MovieJsonHandler.loadMoviesFromJsonFile();
        for (Movie movie : movies) {
            if (movie.getMovieId().equals(movieId)) {
                return movie;
            }
        }

        // Якщо фільм з таким ID не знайдено, створити новий фільм
        System.out.print("Введіть назву фільму: ");
        String title = new Scanner(System.in).nextLine();

        // Інші атрибути фільму можна заповнити за потреби
        System.out.print("Введіть режисера фільму: ");
        String director = new Scanner(System.in).nextLine();

        Movie newMovie = new Movie(movieId, title, director);
        saveMovie(newMovie);

        return newMovie;
    }


    private static void saveMovie(Movie movie) {
        List<Movie> movies = MovieJsonHandler.loadMoviesFromJsonFile();
        movies.add(movie);
        MovieJsonHandler.saveMoviesToJsonFile(movies);
    }

    private static void saveDisc(BluRayDisc disc) {
        List<BluRayDisc> discs = MovieJsonHandler.loadDiscsFromJsonFile();
        discs.add(disc);
        MovieJsonHandler.saveDiscsToJsonFile(discs);
    }
}
