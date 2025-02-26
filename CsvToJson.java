package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvToJson {
    public static void main(String[] args) {
        String csvFile = "employee.csv";
        String jsonFile = "employee.json";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = br.readLine();
            if (line == null) {
                System.out.println("Empty CSV file!");
                return;
            }
            String[] headers = line.split(",");

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();


            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ObjectNode jsonObject = objectMapper.createObjectNode();

                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i].trim(), values[i].trim());
                }

                jsonArray.add(jsonObject);
            }


            objectMapper.writeValue(new File(jsonFile), jsonArray);

            System.out.println("CSV successfully converted to JSON: " + jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
