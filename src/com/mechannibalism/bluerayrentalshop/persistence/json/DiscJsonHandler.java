package com.mechannibalism.bluerayrentalshop.persistence.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mechannibalism.bluerayrentalshop.persistence.entity.BluRayDisc;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DiscJsonHandler {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String JSON_FILE_PATH = "src/resources/discs.json";

    public static void writeDiscToJson(BluRayDisc disc) {
        // Зчитуємо поточний вміст файлу
        List<BluRayDisc> discs = readDiscsFromJson();

        // Додаємо новий диск до списку
        discs.add(disc);

        // Серіалізуємо весь список дисків в JSON
        String json = gson.toJson(discs);

        // Записуємо JSON у файл
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<BluRayDisc> readDiscsFromJson() {
        List<BluRayDisc> discs = new ArrayList<>();

        File file = new File(JSON_FILE_PATH);

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Type listType = new TypeToken<List<BluRayDisc>>() {
                }.getType();
                discs = gson.fromJson(reader, listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return discs;
    }
}
