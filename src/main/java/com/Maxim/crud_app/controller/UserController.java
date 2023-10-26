package com.Maxim.crud_app.controller;

import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.view.DeveloperView;

import java.io.IOException;
import java.util.Scanner;

public class UserController {
    public void getCommandConsole() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().toLowerCase();
        DeveloperController developerController = new DeveloperController();
        SkillsController skillsController = new SkillsController();
        SpecialtyController specialtyController = new SpecialtyController();
        DeveloperView developerView = new DeveloperView();

        switch (command) {
            case "read developers":
                developerController.getAllDevelopers();
                break;

            case "read skills":
                skillsController.getAllSkills();
                break;

            case "read specialty":
                specialtyController.getAllSpecialty();
                break;

            case "get developer by id":

                Developer developer = developerController.getDeveloperById();
                developerView.outputDeveloperById(developer);

                break;

            case "delete developer by id":
             developerController.deleteDeveloperById();
             break;

            case "update developer by id":
                developerController.updateDeveloperById();
                break;

            default:
                System.out.println("Проверьте правильность введенной команды");
        }

//        if (command.equalsIgnoreCase("read developers")) {
//
//
//        } else if (command.equalsIgnoreCase("read skills")) {
//            SkillsController skillsController = new SkillsController();
//            skillsController.getAllSkills();
//
//        } else if (command.equalsIgnoreCase("read specialty")) {
//            SpecialtyController specialtyController = new SpecialtyController();
//            specialtyController.getAllSpecialty();
//
//        } else if (){
//
//        } else {
//            System.out.println("Проверьте правильность введенной команды");
//        }
    }

}

