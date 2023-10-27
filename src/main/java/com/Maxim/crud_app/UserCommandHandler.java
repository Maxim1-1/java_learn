package com.Maxim.crud_app;

import com.Maxim.crud_app.controller.DeveloperController;
import com.Maxim.crud_app.controller.SkillsController;
import com.Maxim.crud_app.controller.SpecialtyController;

import java.util.HashMap;
import java.util.Scanner;

public class UserCommandHandler {
    public void getCommandConsole() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().toLowerCase();

        DeveloperController developerController = new DeveloperController();
        SkillsController skillsController = new SkillsController();
        SpecialtyController specialtyController = new SpecialtyController();

        switch (command) {
            case "get all developers":
                developerController.getAllDevelopers();
                break;

            case "get all skills":
                skillsController.getAllSkills();
                break;

            case "get all specialty":
                specialtyController.getAllSpecialty();
                break;

            case "get developer by id":
                developerController.getDeveloperById();
                break;

            case "get skill by id":
                skillsController.getSkillById();
                break;

            case "get specialty by id":
                specialtyController.getSpecialtyById();
                break;

            case "delete developer by id":
                developerController.deleteDeveloperById();
                break;

            case "delete skill by id":
                skillsController.deleteSkillsById();
                break;

            case "delete specialty by id":
                specialtyController.deleteSpecialtyById();
                break;

            case "update developer by id":
                developerController.updateDeveloperById();
                break;

//            case "update specialty by id":
//                specialtyController.updateDeveloperById();
//                break;

            case "update skill by id":
//                skillsController.updateDeveloperById();

            case "add developer":
                developerController.addNewDeveloper();
                break;

            case "add skill":
                skillsController.addNewSkill();
                break;

            case "add specialty":
                specialtyController.addNewSpecialty();
                break;
            case "exit":
                System.out.println("Вы вышли из приложения");

            default:
                System.out.println("Проверьте правильность введенной команды для выхода введите exit");
        }


    }

}

