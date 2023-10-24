package task_1_3.developer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import task_1_3.developer.developer_atribute.skills.Skill;
import task_1_3.developer.developer_atribute.specialty.Specialty;
import task_1_3.developer.developer_model.Developer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
    String path = "src/main/java/task_1_3/data/developer.json";


    public String readDataFromFileDeveloper() throws IOException {


        try {
            FileReader reader = new FileReader(path);

            JSONParser jsonParser = new JSONParser();
            //ну тут кароч должен массив записываться ну и вообще не записываться а добавляться
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // получение строки из объекта
            String firstName = (String) jsonObject.get("id");
            return firstName;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void add(Developer developer) {

        try {
            // Чтение существующего файла JSON в виде строки
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String jsonStr = "";
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStr += line;
            }
            reader.close();

            // Преобразование строки JSON в объект Gson
            JsonArray jsonArray = JsonParser.parseString(jsonStr).getAsJsonArray();

            // Создание нового объекта JSON
            Gson gson = new Gson();
            JsonObject jsonDeveloper = gson.toJsonTree(developer).getAsJsonObject();

            // Добавление нового объекта JSON в массив
            jsonArray.add(jsonDeveloper);

            // Запись обновленных данных обратно в файл JSON
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(gson.toJson(jsonArray));
            writer.close();

            System.out.println("Объект успешно добавлен в файл JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void putDataFromFileDeveloper() {

    }


    public void addDataFromFileDeveloper(Developer developer) {

        Gson gson = new Gson();

        String json = gson.toJson(developer);

        try (FileWriter writer = new FileWriter(path)) {

            gson.toJson(developer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(json);

    }


    public void removeDataFromFileDeveloper() {

    }
}
