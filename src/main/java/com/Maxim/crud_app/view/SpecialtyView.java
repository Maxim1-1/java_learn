package com.Maxim.crud_app.view;


import com.Maxim.crud_app.model.Specialty;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SpecialtyView {
    private HashMap<String, String> outputSpecialtyData = new HashMap<>();

    public HashMap<String, String> getOutputSkillData() {
        return outputSpecialtyData;
    }
    public void outputDataAllSpecialty(List<Specialty> specialties) {
        for (Specialty specialty : specialties) {
            // потом сделать через стринг буфер или что-то еще оптимальное
            System.out.println("id: " + specialty.getId() + ", specialty: " + specialty.getName());
        }
    }

}
