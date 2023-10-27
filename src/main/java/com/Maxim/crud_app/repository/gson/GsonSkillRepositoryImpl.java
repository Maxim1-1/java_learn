package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.base.Status;
import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.repository.SkillRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GsonSkillRepositoryImpl implements SkillRepository {

    String path = "src/main/java/task_1_3/data/skills.json";

    @Override
    public Skill getById(Integer skillId) {
        return getAll().stream()
                .filter(skill -> skill.getId() == skillId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Skill> getAll() {
        Gson gson = new Gson();
        // поменять путь
        String jsonString = read("C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\skills.json");
        Type type = new TypeToken<List<Skill>>() {
        }.getType();

        List<Skill> skills = gson.fromJson(jsonString, type);

        return skills;
    }

    @Override
    public void save(Skill skill) {

    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public void deleteById(Integer deleteId) {
        List<Skill> skills = getAll();
        for (Skill skill : skills) {
            if (skill.getId() == deleteId) {
                skill.setStatus(Status.DELETED);

            }
        }
        write(skills, "C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\js.json");


    }

    public boolean isCheckTheValueInRepository(Skill expectedSkill) {
        return getAll().stream()
                .anyMatch(skill -> skill.getSkill().equalsIgnoreCase(expectedSkill.getSkill()));
    }


    public Integer getIdForNewSkill() {
        Integer maxId = getMaxIdFromRepository("C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\js.json");
        if ( maxId!= 1) {
            return maxId+ 1;
        } else {
            return 1;
        }

    }
}
