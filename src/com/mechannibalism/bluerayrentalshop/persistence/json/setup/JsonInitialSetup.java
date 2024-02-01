package com.mechannibalism.bluerayrentalshop.persistence.json.setup;

import java.io.File;
import java.io.IOException;

public class JsonInitialSetup {

    private static final String RESOURCES_FOLDER = "resources";
    private static final String DISCS_JSON_FILE = RESOURCES_FOLDER + "/discs.json";
    private static final String USERS_JSON_FILE = RESOURCES_FOLDER + "/users.json";

    public static void performInitialSetup() {
        createResourcesFolder();
        createJsonFileIfNotExists(DISCS_JSON_FILE);
        createJsonFileIfNotExists(USERS_JSON_FILE);
    }

    private static void createResourcesFolder() {
        File resourcesFolder = new File(RESOURCES_FOLDER);
        if (!resourcesFolder.exists()) {
            boolean created = resourcesFolder.mkdirs();
            if (created) {
                System.out.println("Створено папку resources.");
            } else {
                System.err.println("Не вдалося створити папку resources.");
            }
        }
    }

    private static void createJsonFileIfNotExists(String filePath) {
        File jsonFile = new File(filePath);
        if (!jsonFile.exists()) {
            try {
                boolean created = jsonFile.createNewFile();
                if (created) {
                    System.out.println("Створено " + filePath);
                } else {
                    System.err.println("Не вдалося створити " + filePath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
