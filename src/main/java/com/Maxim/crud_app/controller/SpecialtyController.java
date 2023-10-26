
package com.Maxim.crud_app.controller;


import com.Maxim.crud_app.repository.gson.GsonSkillRepositoryImpl;
import com.Maxim.crud_app.repository.gson.GsonSpecialtyRepositoryImpl;
import com.Maxim.crud_app.view.SkillsView;
import com.Maxim.crud_app.view.SpecialtyView;

public class SpecialtyController {
    public void getAllSpecialty() {
        SpecialtyView specialtyView = new SpecialtyView();

        GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();

        specialtyView.outputDataAllSpecialty(gsonSpecialtyRepository.getAll());
    }

}
