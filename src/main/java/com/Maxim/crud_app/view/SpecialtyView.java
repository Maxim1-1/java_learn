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
            System.out.println("id: " + specialty.getId() + ", Specialty: " + specialty.getName()+", Status: "+specialty.getStatus());
        }
    }

    public void outputDataAboutSpecialtyById(Specialty specialty) {
        System.out.println("id: " + specialty.getId() + ", Specialty: " + specialty.getName()+", Status: "+specialty.getStatus());
    }

    public HashMap<String,String> getDataNewSpecialty() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите specialty");
        outputSpecialtyData.put("specialty",scanner.nextLine());
        return outputSpecialtyData;
    }

    public HashMap<String, String> requestDataForUpdateSpecialty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите id записи");
        outputSpecialtyData.put("id", scanner.nextLine());
        System.out.println("Укажите новое значение специльности");
        outputSpecialtyData.put("newValueSpecialty", scanner.nextLine());
        return outputSpecialtyData;
    }

}
