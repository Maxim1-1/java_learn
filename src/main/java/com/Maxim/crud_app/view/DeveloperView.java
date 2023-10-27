package com.Maxim.crud_app.view;


import com.Maxim.crud_app.base.BaseView;
import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DeveloperView implements BaseView {

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


    public void outputDataAboutDeveloperById(Developer developer) {
        String skills = "";
        for (Skill skill : developer.getSkills()) {
            skills += skill.getSkill() + ",";
        }
        // потом сделать через стринг буфер или что-то еще оптимальное
        System.out.println("id: " + developer.getId() + ", First Name: " + developer.getFirstName() + ", Last Name: "
                + developer.getLastName() + ", Specialty: " + developer.getSpecialty().getName() + ", Skills: " + skills);
    }

    public HashMap<String, String> requestDataForUpdateDeveloper() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Укажите id записи"));
        outputUserData.put("id", scanner.nextLine());

        System.out.println(String.format("Выберите из списка один или несколько параметров(через запятую) для изменения: firstName, lastName, specialty, replace skills, add new skills"));
        String[] params = scanner.nextLine().split(",");
        for (String param : params) {
            System.out.printf("Новое значение для %s%n", param);
            outputUserData.put(param, scanner.nextLine());
        }
        return outputUserData;

    }

    public HashMap<String, String> getDataNewDeveloper() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.format("Введите first Name"));
        outputUserData.put("firstName", scanner.nextLine());
        System.out.println(String.format("Введите last Name"));
        outputUserData.put("lastName", scanner.nextLine());
        System.out.println(String.format("Введите specialty"));// вызвать вьюху из special
        outputUserData.put("specialty", scanner.nextLine());
        System.out.println(String.format("Введите skills через запятую"));// вызвать вьюху из skill
        outputUserData.put("skills", scanner.nextLine());
        return outputUserData;
    }

}
