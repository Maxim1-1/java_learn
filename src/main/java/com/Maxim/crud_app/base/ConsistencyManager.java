package com.Maxim.crud_app.base;

import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.repository.gson.GsonDeveloperRepositoryImpl;
import com.Maxim.crud_app.repository.gson.GsonSkillRepositoryImpl;
import com.Maxim.crud_app.repository.gson.GsonSpecialtyRepositoryImpl;

public class ConsistencyManager {
    public void SynchronizationOfTables () {
        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();
        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();


    }
}
