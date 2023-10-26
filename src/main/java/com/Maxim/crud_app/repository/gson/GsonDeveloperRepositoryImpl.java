package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.base.Status;
import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.repository.DeveloperRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
    String path = "src/main/java/task_1_3/data/developer.json";


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
        // поменять путь
        String jsonString = read("C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\js.json");
        Type type = new TypeToken<List<Developer>>() {
        }.getType();

        List<Developer> developers = gson.fromJson(jsonString, type);

        return developers;
    }

    @Override
    public Developer save(Developer developer) {
        return null;
    }

    @Override
    public void update(Developer developer) {
        List<Developer> developers = new ArrayList<>();
        developers = getAll();

        for (int dev = 0; dev < developers.size(); dev++) {
            {
                if (developers.get(dev).getId() == developer.getId()) {
                    developers.set(dev, developer);
                }
            }
            int s =1 ;
            write(developers, "C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\js.json");
            System.out.println("Update");
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
        write(developers,"C:\\Users\\maksgodofwar\\IdeaProjects\\java_learn\\src\\main\\java\\com\\Maxim\\crud_app\\data\\js.json");


    }
}

