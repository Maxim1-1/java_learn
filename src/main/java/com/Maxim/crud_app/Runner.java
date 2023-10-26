package com.Maxim.crud_app;

//import com.Maxim.crudapp.base.controller.DeveloperController;

import com.Maxim.crud_app.controller.UserController;
import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.repository.gson.GsonDeveloperRepositoryImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Runner {
    public static void main(String[] args)  {

        UserController userController = new UserController();
        userController.getCommandConsole();

    }
}



