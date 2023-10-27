package com.Maxim.crud_app.repository;

import com.Maxim.crud_app.model.Developer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer, Integer> {
    @Override
    default int getMaxIdFromRepository(String repositoryPath) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Developer>>() {}.getType();
            List<Developer> developers = gson.fromJson(read(repositoryPath), type);
            if (developers==null) {
                return 1;
            }
            return developers.stream()
                    .mapToInt(Developer::getId)
                    .max()
                    .orElse(1);
    }

}