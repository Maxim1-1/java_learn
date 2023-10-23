package task_1_3.developer.developer_atribute.skills;

import com.google.gson.Gson;
import task_1_3.developer.developer_model.Developer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GsonSkillRepositoryImpl implements SkillRepository {

    String path = "C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\task_1_3\\data\\skills.json";




    public String readDataFromFileDeveloper() {

        return "";
    }


    public void putDataFromFileDeveloper() {

    }


    public void addDataFromFile(List<Skill> skills) {

        Gson gson = new Gson();

        String json = gson.toJson(skills);

        try (FileWriter writer = new FileWriter(path)) {

            gson.toJson(skills, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(json);

    }


    public void removeDataFromFileDeveloper() {

    }
}
