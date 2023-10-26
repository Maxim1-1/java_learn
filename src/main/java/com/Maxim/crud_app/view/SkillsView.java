package com.Maxim.crud_app.view;

import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;

import java.util.HashMap;
import java.util.List;

public class SkillsView {
    private HashMap<String, String> outputSkillData = new HashMap<>();

    public HashMap<String, String> getOutputSkillData() {
        return outputSkillData;

    }

    public void outputDataAllSkills(List<Skill> skills) {
        for (Skill skill : skills) {
            // потом сделать через стринг буфер или что-то еще оптимальное
            System.out.println("id: " + skill.getId() + ", skill: " + skill.getSkill());
        }
    }
}
