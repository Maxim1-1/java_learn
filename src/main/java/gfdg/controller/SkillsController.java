//package com.maksim.crudapp.controller;
//
//import com.maksim.crudapp.view.DeveloperView;
//import com.maksim.crudapp.view.SkillsView;
//import com.maksim.crudapp.model.Skill;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class SkillsController {
//
//    public List<Skill> createSkill(int skillId) {
//
//        SkillsView skillsView = new SkillsView();
//        skillsView.create();
//
//        HashMap<String, String> skillsInputConsoleData = skillsView.getOutputSkillData();
//        List<Skill> skills = new ArrayList<>();
//
//        // оптимизировать цикл мб
//        for (int i = 0; i < skillsInputConsoleData.get("skills").split(",").length; i++) {
//            skills.add(new Skill());
//            skills.get(i).setId(skillId);
//            skills.get(i).setSkill(skillsInputConsoleData.get("skills").split(",")[i]);
//        }
//
//        return skills;
//    }
//
//    public static String getSpecById (List<Skill> skills, int expectedID) {
//        String skillEnty = "";
//        for (Skill skill :skills) {
//            if (skill.getId()==expectedID) {
//                skillEnty+=skill.getSkill()+"";
////                String.join(",",skillEnty,skill.getSkill());
//                return skillEnty;
//            }
//        }
//        return null;
//    }
//
//    public void updateSkills() {
//        DeveloperView developerView = new DeveloperView();
//        developerView.update();
//
//        HashMap<String, String> developerInputConsoleData = developerView.getOutputUserData();
//
//    }
//
//
//}
