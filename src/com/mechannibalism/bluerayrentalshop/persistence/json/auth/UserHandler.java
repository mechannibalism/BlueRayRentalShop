package com.mechannibalism.bluerayrentalshop.persistence.json.auth;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mechannibalism.bluerayrentalshop.persistence.entity.Customer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserHandler {

    public static final String USERS_JSON_PATH = "src/resources/users.json";
    public static final List<Customer> customers = new ArrayList<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Customer findCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }
/*
    private static List<Customer> readCustomersFromJson() {
        List<Customer> customers = new ArrayList<>();
        File file = new File(USERS_JSON_PATH);

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Customer[] customersArray = gson.fromJson(reader, Customer[].class);
                if (customersArray != null) {
                    customers = List.of(customersArray);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return customers;
    }*/

    public static void saveCustomersToJson() {
        try (FileWriter writer = new FileWriter(USERS_JSON_PATH)) {
            gson.toJson(customers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
