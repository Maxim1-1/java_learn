package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.base.Status;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.repository.SkillRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class GsonSkillRepositoryImpl implements SkillRepository {

    String path = "src/main/java/com/Maxim/crud_app/data/skills.json";

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
        String jsonString = read(path);
        Type type = new TypeToken<List<Skill>>() {
        }.getType();
        List<Skill> skills = gson.fromJson(jsonString, type);

        return skills;
    }

    @Override
    public void save(Skill skill) {
        List<Skill> skills;
        skills = getAll();
        if (skills == null) {
            skills = new ArrayList<>();
        }
        skills.add(skill);

        write(skills, path);
        System.out.println("Skill successfully added");


    }

    @Override
    public void update(Skill updateSkill) {
        List<Skill> allSkills;
        allSkills = getAll();

        for (int skill = 0; skill < allSkills.size(); skill++) {
            {
                if (allSkills.get(skill).getId() == updateSkill.getId()) {
                    allSkills.set(skill, updateSkill);
                }
            }
            write(allSkills, path);
            System.out.println("Update success");
        }


    }

    @Override
    public void deleteById(Integer deleteId) {
        List<Skill> skills = getAll();
        for (Skill skill : skills) {
            if (skill.getId() == deleteId) {
                skill.setStatus(Status.DELETED);
            }
        }
        write(skills, path);


    }

    public boolean isCheckTheValueInRepository(Skill expectedSkill) {
        return getAll().stream()
                .anyMatch(skill -> skill.getSkill().equalsIgnoreCase(expectedSkill.getSkill()));
    }

}
