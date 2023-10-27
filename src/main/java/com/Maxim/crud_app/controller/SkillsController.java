package com.Maxim.crud_app.controller;


import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.repository.gson.GsonSkillRepositoryImpl;
import com.Maxim.crud_app.repository.gson.GsonSpecialtyRepositoryImpl;
import com.Maxim.crud_app.view.SkillsView;
import com.Maxim.crud_app.view.SpecialtyView;

import java.util.*;
import java.util.stream.Collectors;

public class SkillsController {

    public void getSkillById() {
        SkillsView skillsView = new SkillsView();
        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

        Skill skillId = gsonSkillRepository.getById(skillsView.getIdFromConsole());
        skillsView.outputSkillById(skillId);
    }

    public void getAllSkills() {
        SkillsView skillsView = new SkillsView();
        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

        skillsView.outputDataAllSkills(gsonSkillRepository.getAll());
    }

    public void deleteSkillsById() {
        SkillsView skillsView = new SkillsView();
        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

        gsonSkillRepository.deleteById(skillsView.getIdFromConsole());
    }

    public void addNewSkill() {
        SkillsView skillsView = new SkillsView();
        GsonSkillRepositoryImpl gsonSkillRepository= new GsonSkillRepositoryImpl();

        List<String> skillsDeveloper = Arrays.asList(skillsView.getDataNewSkill().get("skills").split(","));
        List<Skill> skills = skillsDeveloper.stream().
                map(skillName -> {
                    Skill skill = new Skill();
                    skill.setSkill(skillName);
                    return skill;
                })
                .collect(Collectors.toList());

        for (Skill skill:skills) {
            gsonSkillRepository.save(skill);
        }
    }

    public void updateSkillsById() {
        SkillsView skillsView = new SkillsView();
        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();
        HashMap<String, String> dataFromConsole = skillsView.requestDataForUpdateSkill();
        Integer updateId = Integer.valueOf(dataFromConsole.get("id"));

        for (Skill skill : gsonSkillRepository.getAll()) {
            if (skill.getId() == updateId) {
                skill.setSkill(dataFromConsole.get("newValueSkill"));
                gsonSkillRepository.update(skill);
            }
        }
    }

}
