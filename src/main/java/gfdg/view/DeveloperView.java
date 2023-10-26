//package com.maksim.crudapp.view;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class DeveloperView {
//
//    private HashMap<String,String> outputUserData =  new HashMap<>();
//    public HashMap<String,String> getOutputUserData() {
//        return outputUserData;
//    }
//
//    public void create () {
//        // раздробить метод мб
//        FacadeModel facadeModel = new FacadeModel();
//
//        ArrayList<String> dataDeveloperModel =  facadeModel.getDataAboutDeveloperModel();
//
//        for (String  fieldModel:dataDeveloperModel) {
//            System.out.println(String.format("Введите %s",fieldModel));
//            // тут нужно написать чтобы скилы вводились через запятую
//            Scanner scanner = new Scanner(System.in);
//            outputUserData.put(fieldModel,scanner.nextLine());
//        }
//
//    }
//
//    public void read () {
//
//        FacadeModel facadeModel = new FacadeModel();
//
////        ArrayList<String> dataDevelopers=  facadeModel.getAllDevelopersData();
////         System.out.println(String.format(dataDevelopers));
//    }
//
//    public void update () {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(String.format("Укажите id записи"));
//        outputUserData.put("id",scanner.nextLine());
//
//        System.out.println(String.format("Какой параметр хотите изменить"));
//        outputUserData.put("oldParam",scanner.nextLine());
//
//        System.out.println(String.format("Новое значение"));
//        outputUserData.put("newValue",scanner.nextLine());
//    }
//
//    public void delete () {
//        System.out.println(String.format("Укажите id записи которую необходимо удалить и <параметр>:<новое значение>"));
//        // 11, firstName:john, ...
//    }
//
//
//
//}
