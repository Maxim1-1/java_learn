//package com.maksim.crudapp.view;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class SpecialtyView {
//    private HashMap<String, String> outputSpecialtyData = new HashMap<>();
//
//    public HashMap<String, String> getOutputSkillData() {
//        return outputSpecialtyData;
//    }
//
//    public void create() {
//        FacadeModel facadeModel = new FacadeModel();
//
//        ArrayList<String> dataSpecialtyModel = facadeModel.getDataAboutSpecialtyModel();
//
//        System.out.println("Введите специальность");
//        Scanner scanner = new Scanner(System.in);
//        outputSpecialtyData.put(dataSpecialtyModel.get(0), scanner.nextLine());
//    }
//
//    public void update () {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(String.format("Укажите id записи"));
//        outputSpecialtyData.put("id",scanner.nextLine());
//
//        System.out.println(String.format("Укажите новую специальность"));
//        outputSpecialtyData.put("oldParam",scanner.nextLine());
//
//    }
//}
