package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeJson {
    public static void main(String[] args) {
        String path1 = "sample.json";
        String path2 = "demo.json";
        String mergedJson = "merged.json";

        try {
            // Read JSON files as Strings
            String json1 = new String(Files.readAllBytes(Paths.get(path1)));
            String json2 = new String(Files.readAllBytes(Paths.get(path2)));

            // Convert Strings to JSONObjects or JSONArrays
            Object obj1 = parseJson(json1);
            Object obj2 = parseJson(json2);

            // Merge JSON structures
            JSONArray mergedArray = new JSONArray();

            if (obj1 instanceof JSONObject) {
                mergedArray.put((JSONObject) obj1);
            } else if (obj1 instanceof JSONArray) {
                for (int i = 0; i < ((JSONArray) obj1).length(); i++) {
                    mergedArray.put(((JSONArray) obj1).getJSONObject(i));
                }
            }

            if (obj2 instanceof JSONObject) {
                mergedArray.put((JSONObject) obj2);
            } else if (obj2 instanceof JSONArray) {
                for (int i = 0; i < ((JSONArray) obj2).length(); i++) {
                    mergedArray.put(((JSONArray) obj2).getJSONObject(i));
                }
            }

            // Write merged JSON to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergedJson))) {
                writer.write(mergedArray.toString(4));
            }

            System.out.println("Merged JSON successfully written to " + mergedJson);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    // Helper method to parse JSON (handles both objects and arrays)
    private static Object parseJson(String json) {
        try {
            if (json.trim().startsWith("[")) {
                return new JSONArray(json);
            } else {
                return new JSONObject(json);
            }
        } catch (JSONException e) {
            System.out.println("Invalid JSON format: " + e.getMessage());
            return null;
        }
    }
}
