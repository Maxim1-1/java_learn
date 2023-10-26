package com.maksim.crudapp.utils;

import com.google.gson.*;
import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.FileReader;

public class DeveloperUtils {

    public static int getMaxIdFromDeveloperJson () {

        String file = "C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com.maksim.task_1_3\\data\\developer.json";

        String jsonString = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonString += line;
            }
            bufferedReader.close();

            JsonArray jsonArray = new Gson().fromJson(jsonString, JsonArray.class);

            int maxId = 0;

            for (var element : jsonArray) {

                JsonObject jsonObject = element.getAsJsonObject();
                int id = jsonObject.get("id").getAsInt();
                if (id > maxId) {
                    maxId = id;
                }
            }

            return maxId;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Массив пуст");
        }
        return 0;
    }


}
