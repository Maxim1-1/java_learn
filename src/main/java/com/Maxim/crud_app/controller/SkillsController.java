package com.Maxim.crud_app.controller;


import com.Maxim.crud_app.repository.gson.GsonDeveloperRepositoryImpl;
import com.Maxim.crud_app.repository.gson.GsonSkillRepositoryImpl;
import com.Maxim.crud_app.view.DeveloperView;
import com.Maxim.crud_app.view.SkillsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SkillsController {

    public void getAllSkills() {
        SkillsView skillsView = new SkillsView();

        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

        skillsView.outputDataAllSkills(gsonSkillRepository.getAll());
    }


}
