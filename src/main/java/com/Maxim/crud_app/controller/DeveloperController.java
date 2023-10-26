package com.Maxim.crud_app.controller;


import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.repository.gson.GsonDeveloperRepositoryImpl;
import com.Maxim.crud_app.view.DeveloperView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

    public Developer getDeveloperById() {
        DeveloperView developerView = new DeveloperView();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        return gsonDeveloperRepository.getById(developerView.getId());
    }

    public void deleteDeveloperById() {
        DeveloperView developerView = new DeveloperView();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        gsonDeveloperRepository.deleteById(developerView.getId());
    }


    public void updateDeveloperById() {
        DeveloperView developerView = new DeveloperView();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();

        HashMap<String, String> dataFromConsole = developerView.requestDataForUpdateDeveloper();
        Integer updateId = Integer.valueOf(dataFromConsole.get("id"));

        switch (dataFromConsole.get("param")) {
            case "firstName":

                Developer updateDeveloperFirstName = null;

                for (Developer developer : gsonDeveloperRepository.getAll()) {
                    if (developer.getId() == updateId) {
                        developer.setFirstName(dataFromConsole.get("newValue"));
                        updateDeveloperFirstName = developer;

                    }
                }
                ;
                gsonDeveloperRepository.update(updateDeveloperFirstName);
                break;
            case "lastName":
                Developer updateDeveloperLastName = null;

                for (Developer developer : gsonDeveloperRepository.getAll()) {
                    if (developer.getId() == updateId) {
                        developer.setLastName(dataFromConsole.get("newValue"));
                        updateDeveloperLastName = developer;
                    }
                }
                ;
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
                ;
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
                ;

                gsonDeveloperRepository.update(updateDeveloperSkills);

                break;


        }


    }


}
