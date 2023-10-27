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
            // потом сделать через стринг буфер или что-то еще оптимальное
            outputSkillById(skill);
        }
    }

    public void outputSkillById(Skill skill) {
        System.out.println("id: " + skill.getId() + ", Skills: " + skill.getSkill());
    }

    public HashMap<String,String> getDataNewSkill() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.format("Введите skills через запятую"));
        outputSkillData.put("skills",scanner.nextLine());
        return outputSkillData;
    }


}
