package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.base.Status;
import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.repository.DeveloperRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
    String path = "src/main/java/com/Maxim/crud_app/data/developer.json";


    @Override
    public Developer getById(Integer id) {
        return getAll().stream()
                .filter(developer -> developer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Developer> getAll() {
        Gson gson = new Gson();
        String jsonString = read(path);
        Type type = new TypeToken<List<Developer>>() {
        }.getType();

        List<Developer> developers = gson.fromJson(jsonString, type);

        return developers;
    }

    @Override
    public void save(Developer developer) {
        List<Developer> developers;
        developers = getAll();
        if (developers == null) {
            developers = new ArrayList<>();
        }
        developers.add(developer);

        write(developers, path);
        System.out.println("Developer successfully added");
    }

    @Override
    public void update(Developer developer) {
        List<Developer> developers;
        developers = getAll();

        for (int dev = 0; dev < developers.size(); dev++) {
            {
                if (developers.get(dev).getId() == developer.getId()) {
                    developers.set(dev, developer);
                }
            }
            write(developers, path);
            System.out.println("Update success");
        }
    }

    @Override
    public void deleteById(Integer deleteId) {
        List<Developer> developers = getAll();

        for (Developer developer : developers) {
            if (developer.getId() == deleteId) {
                developer.setStatus(Status.DELETED);

            }
        }
        write(developers, path);
    }


    public void updateSkillAndSpecialty(Specialty specialty, List<Skill> skills) {
        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();
        GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();

        if (!gsonSpecialtyRepository.isCheckTheValueInRepository(specialty)) {
            gsonSpecialtyRepository.save(specialty);
        }
        for (Skill skill : skills) {
            if (!gsonSkillRepository.isCheckTheValueInRepository(skill)) {
                gsonSkillRepository.save(skill);
            }
        }
    }
}

