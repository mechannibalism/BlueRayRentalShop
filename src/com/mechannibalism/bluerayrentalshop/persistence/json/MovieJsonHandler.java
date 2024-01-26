package com.mechannibalism.bluerayrentalshop.persistence.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mechannibalism.bluerayrentalshop.persistence.entity.BluRayDisc;
import com.mechannibalism.bluerayrentalshop.persistence.entity.Movie;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieJsonHandler {

    private static final String DISCS_JSON_FILE_PATH = "src/resources/blu_ray_discs.json";
    private static final String MOVIES_JSON_FILE_PATH = "src/resources/movies.json";

    // Збереження дисків у JSON файл
    public static void saveDiscsToJsonFile(List<BluRayDisc> discs) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Перевірка і створення каталогу та файлу, якщо вони не існують
            File file = new File(DISCS_JSON_FILE_PATH);
            File directory = file.getParentFile();
            if (!directory.exists()) {
                directory.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }

            objectMapper.writeValue(file, discs);
            System.out.println("Диски збережено у файл " + DISCS_JSON_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Завантаження дисків з JSON файлу
    public static List<BluRayDisc> loadDiscsFromJsonFile() {
        try {
            File file = new File(DISCS_JSON_FILE_PATH);
            if (file.exists()) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(file, new TypeReference<List<BluRayDisc>>() {
                });
            } else {
                System.out.println("Файл " + DISCS_JSON_FILE_PATH + " не існує.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Збереження фільмів у JSON файл
    public static void saveMoviesToJsonFile(List<Movie> movies) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Перевірка і створення файлу, якщо він не існує
            File file = new File(MOVIES_JSON_FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }

            objectMapper.writeValue(file, movies);
            System.out.println("Фільми збережено у файл " + MOVIES_JSON_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Завантаження фільмів з JSON файлу
    public static List<Movie> loadMoviesFromJsonFile() {
        try {
            File file = new File(MOVIES_JSON_FILE_PATH);
            if (file.exists()) {
                ObjectMapper objectMapper = new ObjectMapper();
                List<Movie> movies = objectMapper.readValue(file, new TypeReference<List<Movie>>() {
                });
                return movies;
            } else {
                System.out.println("Файл " + MOVIES_JSON_FILE_PATH + " не існує.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); // Повертаємо пустий список, щоб уникнути NullPointerException
    }
}
