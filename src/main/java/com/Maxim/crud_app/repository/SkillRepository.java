package com.Maxim.crud_app.repository;

import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public interface SkillRepository extends GenericRepository<Skill,Integer> {
    @Override
    default int getMaxIdFromRepository(String repositoryPath) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Developer>>() {}.getType();
        List<Skill> developers = gson.fromJson(read(repositoryPath), type);
        return developers.stream()
                .mapToInt(Skill::getId)
                .max()
                .orElse(1);
    }

}
