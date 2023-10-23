package task_1_3.developer.developer_atribute.specialty;

import com.google.gson.Gson;
import task_1_3.developer.developer_model.Developer;

import java.io.FileWriter;
import java.io.IOException;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {

    String path = "C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\task_1_3\\data\\specialty.json";


    public String readDataFromFileDeveloper() {

        return "";
    }


    public void putDataFromFileDeveloper() {

    }


    public void addDataFromFileDeveloper(Specialty specialty) {
        Gson gson = new Gson();

        String json = gson.toJson(specialty);

        try (FileWriter writer = new FileWriter(path)) {

            gson.toJson(specialty, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(json);

    }


    public void removeDataFromFileDeveloper() {

    }
}
