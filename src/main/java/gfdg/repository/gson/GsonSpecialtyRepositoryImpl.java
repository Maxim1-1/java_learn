//package com.maksim.crudapp.repository.gson;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.maksim.crudapp.model.Specialty;
//import com.maksim.crudapp.repository.SpecialtyRepository;
//
//import java.io.*;
//
//public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {
//
//    String path = "src/main/java/com.maksim.task_1_3/data/specialty.json";
//
//
//    public String readDataFromFileDeveloper() {
//
//        return "";
//    }
//
//
//    public void putDataFromFileDeveloper() {
//
//    }
//
//
//    public void add(Specialty specialty) {
//        try {
//            // Чтение существующего файла JSON в виде строки
//            BufferedReader reader = new BufferedReader(new FileReader(path));
//            String jsonStr = "";
//            String line;
//            while ((line = reader.readLine()) != null) {
//                jsonStr += line;
//            }
//            reader.close();
//
//            // Преобразование строки JSON в объект Gson
//            JsonArray jsonArray = JsonParser.parseString(jsonStr).getAsJsonArray();
//
//
//
//            // Создание нового объекта JSON
//            Gson gson = new Gson();
//            JsonObject jsonDeveloper = gson.toJsonTree(specialty).getAsJsonObject();
//
//            // Добавление нового объекта JSON в массив
//            jsonArray.add(jsonDeveloper);
//
//            // Запись обновленных данных обратно в файл JSON
//            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
//            writer.write(gson.toJson(jsonArray));
//            writer.close();
//
//
//            System.out.println("Объект успешно добавлен в файл JSON.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public void removeDataFromFileDeveloper() {
//
//    }
//}
