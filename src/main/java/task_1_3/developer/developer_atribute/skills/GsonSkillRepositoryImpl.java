package task_1_3.developer.developer_atribute.skills;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import task_1_3.developer.developer_atribute.specialty.Specialty;
import task_1_3.developer.developer_model.Developer;

import java.io.*;
import java.util.List;

public class GsonSkillRepositoryImpl implements SkillRepository {

    String path = "src/main/java/task_1_3/data/skills.json";




    public String readDataFromFileDeveloper() {

        return "";
    }


    public void putDataFromFileDeveloper() {

    }


    public void add(List<Skill> skills) {

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


            for (Skill skill:skills) {
                JsonObject jsonSkill = gson.toJsonTree(skill).getAsJsonObject();
                // Добавление нового объекта JSON в массив
                jsonArray.add(jsonSkill);
            }

            // Запись обновленных данных обратно в файл JSON
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(gson.toJson(jsonArray));
            writer.close();

            System.out.println("Объект успешно добавлен в файл JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void removeDataFromFileDeveloper() {

    }
}
