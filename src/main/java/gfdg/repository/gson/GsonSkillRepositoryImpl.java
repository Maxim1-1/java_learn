//package com.maksim.crudapp.repository.gson;
//
//import com.maksim.crudapp.model.Skill;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GsonSkillRepositoryImpl implements com.maksim.crudapp.repository.GenericRepository<Skill, Integer> {
//
//    private final String path = "src/main/java/com.maksim.task_1_3/data/skills.json";
//
//    private List<Skill> getAllSkillsInternal() {
//        return new ArrayList<>();
//    }
//
//    private void writeSkillsToFile(List<Skill> skills) {
//        //TODO: write as JSON string to file
//    }
//
//    @Override
//    public Skill getById(Integer id) {
//        return getAllSkillsInternal().stream()
//                .filter(s -> s.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }
//
//    @Override
//    public List getAll() {
//        return getAllSkillsInternal();
//    }
//
//    @Override
//    public Skill save(Skill s) {
//        List<Skill> skills = getAllSkillsInternal();
//        //TODO: generate ID for the new Skill
//        s.setId(-1);
//        skills.add(s);
//        writeSkillsToFile(skills);
//        return s;
//    }
//
//    @Override
//    public Skill update(Object o) {
//        return null;
//    }
//
//    @Override
//    public void deleteById(Integer o) {
//
//    }
//}
