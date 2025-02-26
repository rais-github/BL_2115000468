package org.example;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Student{
    private int age;
    private float marks;
    private String name;
    private String email;

    public Student(int age , float marks , String name , String email){
        this.age=age;
        this.marks=marks;
        this.name=name;
        this.email=email;
    }


}

public class ReadSpecificField {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("sample.json")))
        {
            String line;

            while((line = br.readLine())!=null){
                String[] values = line.split(",");
                if(values[0].contains("email") || values[0].contains("name")){
                    System.out.println(values[0].toString());
                }
            }
        }
        catch(IOException e){e.printStackTrace();}
    }
}
