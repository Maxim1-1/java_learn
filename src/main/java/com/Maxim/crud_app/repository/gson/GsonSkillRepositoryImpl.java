package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.repository.SkillRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GsonSkillRepositoryImpl implements SkillRepository {

    String path = "src/main/java/task_1_3/data/skills.json";

    @Override
    public Skill getById(Integer integer) {
        return null;
    }

    @Override
    public List<Skill> getAll() {
        Gson gson = new Gson();
        // поменять путь
        String jsonString = read("C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\skills.json");
        Type type = new TypeToken<List<Skill>>(){}.getType();

        List<Skill> skills = gson.fromJson(jsonString,type);

        return skills;
    }

    @Override
    public Skill save(Skill skill) {
        return null;
    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
