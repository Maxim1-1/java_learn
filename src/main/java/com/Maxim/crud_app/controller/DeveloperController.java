package com.Maxim.crud_app.controller;


import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.model.UpdateParamsDeveloper;
import com.Maxim.crud_app.repository.gson.GsonDeveloperRepositoryImpl;
import com.Maxim.crud_app.repository.gson.GsonSkillRepositoryImpl;
import com.Maxim.crud_app.repository.gson.GsonSpecialtyRepositoryImpl;
import com.Maxim.crud_app.view.DeveloperView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DeveloperController {


    public int getNewDeveloperId() {
        return newDeveloperId;
    }

    int newDeveloperId;


    public void getAllDevelopers() {
        DeveloperView developerView = new DeveloperView();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();

        developerView.outputDataAllDevelopers(gsonDeveloperRepository.getAll());
    }

    public void getDeveloperById() {
        DeveloperView developerView = new DeveloperView();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();

        Developer developerId = gsonDeveloperRepository.getById(developerView.getIdFromConsole());
        developerView.outputDataAboutDeveloperById(developerId);
    }

    public void deleteDeveloperById() {
        DeveloperView developerView = new DeveloperView();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        gsonDeveloperRepository.deleteById(developerView.getIdFromConsole());
    }

    public void updateDeveloperById() {
        DeveloperView developerView = new DeveloperView();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        UpdateParamsDeveloper updateParamsDeveloper = new UpdateParamsDeveloper();

        HashMap<String, String> dataFromConsole = developerView.requestDataForUpdateDeveloper();
        Integer updateId = Integer.valueOf(dataFromConsole.get("id"));

        switch (dataFromConsole.get("params")) {
            case "firstName":

                Developer updateDeveloperFirstName = updateParamsDeveloper.performOperationOnDeveloper(updateId, developer -> developer.setFirstName(dataFromConsole.get("newValue")));
                gsonDeveloperRepository.update(updateDeveloperFirstName);
                break;
            case "lastName":

                Developer updateDeveloperLastName = updateParamsDeveloper.performOperationOnDeveloper(updateId, developer -> developer.setLastName(dataFromConsole.get("newValue")));
                gsonDeveloperRepository.update(updateDeveloperLastName);
                break;
            case "specialty":
                Developer updateDeveloperSpecialty = null;
                Specialty specialty = new Specialty();
                specialty.setName(dataFromConsole.get("newValue"));

                for (Developer developer : gsonDeveloperRepository.getAll()) {
                    if (developer.getId() == updateId) {
                        developer.setSpecialty(specialty);
                        updateDeveloperSpecialty = developer;
                    }
                }
                gsonDeveloperRepository.update(updateDeveloperSpecialty);
                break;
            case "skills":
                Developer updateDeveloperSkills = null;
                String[] skills = dataFromConsole.get("newValue").split(",");
                List<Skill> skillList = new ArrayList<>();

                for (String skill : skills) {
                    Skill newSkill = new Skill();
                    newSkill.setSkill(skill);
                    skillList.add(newSkill);
                }


                for (Developer developer : gsonDeveloperRepository.getAll()) {
                    if (developer.getId() == updateId) {
                        developer.setSkills(skillList);
                        updateDeveloperSkills = developer;
                    }
                }
                gsonDeveloperRepository.update(updateDeveloperSkills);
                break;
        }
    }


    public void addNewDeveloper() {
        DeveloperView developerView = new DeveloperView();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        Specialty specialty = new Specialty();

        List<Skill> skills;
        HashMap<String, String> dataNewDeveloperFromConsole = developerView.getDataNewDeveloper();

        Integer id = gsonDeveloperRepository.getIdForNewDeveloper();
        String firstNameDeveloper = developerView.getDataNewDeveloper().get("firstName");
        String lastNameDeveloper = dataNewDeveloperFromConsole.get("lastName");
        specialty.setName(dataNewDeveloperFromConsole.get("specialty"));
        List<String> skillsDeveloper = Arrays.asList(dataNewDeveloperFromConsole.get("skills").split(","));
        skills = skillsDeveloper.stream().
                map(skillName -> {
                    Skill skill = new Skill();
                    skill.setSkill(skillName);
                    return skill;
                })
                .collect(Collectors.toList());

        Developer developer = new Developer(firstNameDeveloper, lastNameDeveloper, id);
        developer.setSpecialty(specialty);
        developer.setSkills(skills);

        gsonDeveloperRepository.updateSkillAndSpecialty(specialty, skills);
        gsonDeveloperRepository.save(developer);
    }
}
