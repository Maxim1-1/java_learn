//package com.maksim.crudapp.controller;
//
//import com.maksim.crudapp.view.DeveloperView;
//import com.maksim.crudapp.model.Developer;
//import com.maksim.crudapp.utils.DeveloperUtils;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class DeveloperController {
//
//
//    public int getNewDeveloperId() {
//        return newDeveloperId;
//    }
//
//    int newDeveloperId;
//
//
//    public void getCommandConsole() throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String command = scanner.nextLine();
//
//        if (command.equalsIgnoreCase("create")) {
//            FacadeModel.createUserWithSkillSpecialty() ;
//        } else if (command.equalsIgnoreCase("read")) {
//            FacadeModel.readAlldata();
//        } else if (command.equalsIgnoreCase("update")) {
//            updateDeveloper();
//        } else if (command.equalsIgnoreCase("delete")) {
//            deleteDeveloper();
//        } else {
//            System.out.println("Проверьте правильность введенной команды");
//        }
//    }
//
//
//    public Developer createDeveloper() {
//        DeveloperView developerView = new DeveloperView();
//        developerView.create();
//
//        HashMap<String, String> developerInputConsoleData = developerView.getOutputUserData();
//
//        String firstNameConsole = developerInputConsoleData.get("firstName");
//        String lastNameConsole = developerInputConsoleData.get("lastName");
//
//        int maxDeveloperId = DeveloperUtils.getMaxIdFromDeveloperJson();
//        newDeveloperId = maxDeveloperId + 1;
//
//        return new Developer(firstNameConsole, lastNameConsole, newDeveloperId);
//    }
//
//    public void readDataOfDeveloper() {
//
//    }
//
//    public void deleteDeveloper() {
//
//    }
//
//    public void updateDeveloper() {
//        DeveloperView developerView = new DeveloperView();
//        developerView.update();
//
//        HashMap<String, String> developerInputConsoleData = developerView.getOutputUserData();
//
//    }
//
//
//}
