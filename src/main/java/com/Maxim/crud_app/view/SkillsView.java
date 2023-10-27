package com.Maxim.crud_app.view;

import com.Maxim.crud_app.base.BaseView;
import com.Maxim.crud_app.model.Skill;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SkillsView implements BaseView {
    private HashMap<String, String> outputSkillData = new HashMap<>();

    public void outputDataAllSkills(List<Skill> skills) {
        for (Skill skill : skills) {
            outputSkillById(skill);
        }
    }

    public void outputSkillById(Skill skill) {
        System.out.println("id: " + skill.getId() + ", Skills: " + skill.getSkill()+", Status: "+skill.getStatus());
    }

    public HashMap<String,String> getDataNewSkill() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите skills через запятую");
        outputSkillData.put("skills",scanner.nextLine());
        return outputSkillData;
    }

    public HashMap<String, String> requestDataForUpdateSkill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите id записи");
        outputSkillData.put("id", scanner.nextLine());
        System.out.println("Укажите новое значение скила");
        outputSkillData.put("newValueSkill", scanner.nextLine());
        return outputSkillData;
    }


}
