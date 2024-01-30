package com.mechannibalism.bluerayrentalshop.persistence.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mechannibalism.bluerayrentalshop.persistence.entity.BluRayDisc;
import com.mechannibalism.bluerayrentalshop.persistence.entity.Movie;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MovieJsonHandler {

    private static final String DISCS_JSON_FILE_PATH = "src/resources/blu_ray_discs.json";
    private static final String MOVIES_JSON_FILE_PATH = "src/resources/movies.json";


    // Збереження дисків у JSON файл
    public static void saveDiscsToJsonFile(List<BluRayDisc> discs) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(discs);

            // Запис у файл
            FileWriter writer = new FileWriter(DISCS_JSON_FILE_PATH);
            writer.write(json);
            writer.close();

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
                Gson gson = new Gson();
                FileReader reader = new FileReader(file);

                // Визначення типу даних для десеріалізації
                Type type = new TypeToken<List<BluRayDisc>>() {
                }.getType();

                return gson.fromJson(reader, type);
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
            Gson gson = new Gson();
            String json = gson.toJson(movies);

            // Запис у файл
            FileWriter writer = new FileWriter(MOVIES_JSON_FILE_PATH);
            writer.write(json);
            writer.close();

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
                Gson gson = new Gson();
                FileReader reader = new FileReader(file);

                // Визначення типу даних для десеріалізації
                Type type = new TypeToken<List<Movie>>() {
                }.getType();

                return gson.fromJson(reader, type);
            } else {
                System.out.println("Файл " + MOVIES_JSON_FILE_PATH + " не існує.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
