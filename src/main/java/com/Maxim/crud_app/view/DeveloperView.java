package com.Maxim.crud_app.view;


import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {

    private HashMap<String, String> outputUserData = new HashMap<>();

    public void outputDataAllDevelopers(List<Developer> developers) {

        String skills = "";

        for (Developer developer : developers) {

            String specialty = developer.getSpecialty().getName();

            for (Skill skill : developer.getSkills()) {
                skills += skill.getSkill() + ",";

            }

            // потом сделать через стринг буфер или что-то еще оптимальное
            System.out.println("id: " + developer.getId() + ", First Name: " + developer.getFirstName() + ", Last Name: " + developer.getLastName() + ", Specialty: " + specialty + ", Skills: " + skills);
        }
    }

    public Integer getId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id сущности");
        return scanner.nextInt();
    }

    public void outputDeveloperById(Developer developer) {
        String skills = "";
        for (Skill skill : developer.getSkills()) {
            skills += skill.getSkill() + ",";
        }
        // потом сделать через стринг буфер или что-то еще оптимальное
        System.out.println("id: " + developer.getId() + ", First Name: " + developer.getFirstName() + ", Last Name: "
                + developer.getLastName() + ", Specialty: " + developer.getSpecialty().getName() + ", Skills: " + skills);
    }

    public HashMap<String, String> requestDataForUpdateDeveloper () {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Укажите id записи"));
        outputUserData.put("id",scanner.nextLine());

        System.out.println(String.format("Выберите из списка один параметр для изменения: firstName, lastName, specialty, skills"));
        outputUserData.put("param",scanner.nextLine());

        System.out.println(String.format("Новое значение"));
        outputUserData.put("newValue",scanner.nextLine());
        return outputUserData;

    }

//    public Integer getDeleteId() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите id сущности для удаления");
//        return scanner.nextInt();
//    }
}


