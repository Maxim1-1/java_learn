package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.base.Status;
import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.repository.SpecialtyRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {

    String path = "src/main/java/task_1_3/data/specialty.json";


    @Override
    public Specialty getById(Integer specialtyId) {
        return getAll().stream()
                .filter(specialty -> specialty.getId() == specialtyId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Specialty> getAll() {
        Gson gson = new Gson();
        // поменять путь
        String jsonString = read("C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\specialty.json");
        Type type = new TypeToken<List<Specialty>>(){}.getType();

        List<Specialty> specialties = gson.fromJson(jsonString,type);

        return specialties;
    }

    @Override
    public void save(Specialty specialty) {

    }

    @Override
    public void update(Specialty specialty) {

    }

    @Override
    public void deleteById(Integer deleteId) {
        List<Specialty> specialties = getAll();
        for (Specialty specialty : specialties) {
            if (specialty.getId() == deleteId) {
                specialty.setStatus(Status.DELETED);

            }
        }
        write(specialties,"C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\js.json");

    }

    public boolean isCheckTheValueInRepository(Specialty expectedSpecialty) {
        return getAll().stream()
                .anyMatch(spec -> spec.getName().equalsIgnoreCase(expectedSpecialty.getName()));
    }

    public Integer getIdForNewSpecialty() {
        Integer maxId = getMaxIdFromRepository("C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\js.json");
        if ( maxId!= 1) {
            return maxId+ 1;
        } else {
            return 1;
        }

    }
}

