package com.horarios.mnt.services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
public class JsonImport {


    public class ReadJSONFile {

        public static void main(String[] args) {
            JSONParser parser = new JSONParser();

            try {
                Object obj = parser.parse(new FileReader("example.json"));
                JSONObject jsonObject = (JSONObject) obj;

                String name = (String) jsonObject.get("name");
                System.out.println("Name: " + name);

                long age = (Long) jsonObject.get("age");
                System.out.println("Age: " + age);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
