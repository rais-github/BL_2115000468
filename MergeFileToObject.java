package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeFileToObject {
    public static void main(String[] args) {
        String jsonFile1 = "sample.json";
        String jsonFile2 = "demo.json";
        String outputFile = "merged.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();


            JsonNode node1 = objectMapper.readTree(new File(jsonFile1));
            JsonNode node2 = objectMapper.readTree(new File(jsonFile2));


            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) node1);
            mergedNode.setAll((ObjectNode) node2);


            objectMapper.writeValue(new File(outputFile), mergedNode);

            System.out.println("Merged JSON file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
