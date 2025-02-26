package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Order {
    int orderId;
    String customerName;
    List<String> items;

    public Order(int orderId, String customerName, List<String> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
    }

    // Add getters for Jackson to work properly
    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public List<String> getItems() { return items; }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        try {
            List<Order> orders = Arrays.asList(
                    new Order(1, "Michael", Arrays.asList("Laptop", "Mouse")),
                    new Order(2, "Sophia", Arrays.asList("Tablet", "Keyboard")),
                    new Order(3, "David", Arrays.asList("Monitor", "Webcam"))
            );

            ObjectMapper objectMapper = new ObjectMapper();

            // Convert list to JSON array
            String jsonArray = objectMapper.writeValueAsString(orders);

            // Print JSON output
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
