package com.Maxim.crud_app.view;


import com.Maxim.crud_app.base.BaseView;
import com.Maxim.crud_app.model.Specialty;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SpecialtyView implements BaseView {
    private HashMap<String, String> outputSpecialtyData = new HashMap<>();

    public void outputDataAllSpecialty(List<Specialty> specialties) {
        for (Specialty specialty : specialties) {
            // потом сделать через стринг буфер или что-то еще оптимальное
            System.out.println("id: " + specialty.getId() + ", specialty: " + specialty.getName());
        }
    }

    public void outputDataAboutSpecialtyById(Specialty specialty) {
        System.out.println("id: " + specialty.getId() + ", Skills: " + specialty.getName());
    }

    public HashMap<String,String> getDataNewSpecialty() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.format("Введите specialty"));
        outputSpecialtyData.put("specialty",scanner.nextLine());
        return outputSpecialtyData;
    }

}
