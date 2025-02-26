package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateStudentJson {
    public static void main(String[] args) {
        try {
            JSONObject student = new JSONObject();
            student.put("name", "John Doe");
            student.put("age", 20);

            JSONArray subjects = new JSONArray();
            subjects.put("Math");
            subjects.put("Science");
            subjects.put("History");

            student.put("subjects", subjects);


            System.out.println(student.toString(2));

        } catch (JSONException e) {
            System.err.println("JSON Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
