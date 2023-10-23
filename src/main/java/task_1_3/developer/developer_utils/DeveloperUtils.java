package task_1_3.developer.developer_utils;

import com.google.gson.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONTokener;

public class DeveloperUtils {

    public static int getMaxIdFromDeveloperJson () {

        String file = "C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\task_1_3\\data\\developer.json";

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
