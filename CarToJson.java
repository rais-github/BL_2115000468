package org.example;

import org.json.JSONObject;

class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }


    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("brand", this.brand);
        json.put("model", this.model);
        json.put("year", this.year);
        return json;
    }
}

public class CarToJson {
    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Tesla", "Model S", 2024);


        JSONObject carJson = car.toJson();


        System.out.println(carJson.toString(4));
    }
}
