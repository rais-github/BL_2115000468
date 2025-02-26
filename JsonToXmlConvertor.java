package org.example;

import org.json.JSONObject;
import org.json.XML;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXmlConvertor {
    public static void main(String[] args) {
        String jsonFilePath = "sample.json";
        String xmlFilePath = "output.xml";

        try {

            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));


            JSONObject jsonObject = new JSONObject(jsonContent);


            String xmlContent = XML.toString(jsonObject, "root");


            Files.write(Paths.get(xmlFilePath), xmlContent.getBytes());

            System.out.println("JSON successfully converted to XML: " + xmlFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
