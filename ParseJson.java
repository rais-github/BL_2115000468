package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ParseJson {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file as a JsonNode array
            JsonNode jsonArray = objectMapper.readTree(new File("data.json"));

            // Iterate and filter records where age > 25
            for (JsonNode node : jsonArray) {
                int age = node.get("age").asInt();
                if (age > 25) {
                    System.out.println(node.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
