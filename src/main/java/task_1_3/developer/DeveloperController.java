package task_1_3.developer;

import task_1_3.developer.developer_atribute.skills.Skill;
import task_1_3.developer.developer_atribute.specialty.Specialty;
import task_1_3.developer.developer_model.Developer;
import task_1_3.developer.developer_model.FacadeModel;
import task_1_3.developer.developer_utils.DeveloperUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DeveloperController  {



    public void getCommandConsole() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("create")) {
            createDeveloper();
        } else if (command.equalsIgnoreCase("read")) {
            updateDeveloper();
        } else if (command.equalsIgnoreCase("update")) {
            updateDeveloper();
        } else if (command.equalsIgnoreCase("delete")) {
            deleteDeveloper();
        } else {
            System.out.println("Проверьте правильность введенной команды");
        }
    }


    public void createDeveloper() {
        DeveloperView developerView = new DeveloperView();
        developerView.create();

        HashMap<String, String> developerInputConsoleData=developerView.getOutputUserData();

        String firstNameConsole = developerInputConsoleData.get("firstName");
        String lastNameConsole = developerInputConsoleData.get("lastName");
        String specialtyDeveloperConsole = developerInputConsoleData.get("specialty");
        int maxDeveloperId = DeveloperUtils.getMaxIdFromDeveloperJson();
        int newDeveloperId = maxDeveloperId+1;

        Developer developer = new Developer(firstNameConsole,lastNameConsole,newDeveloperId);

        Specialty specialty = new Specialty();
        specialty.setId(newDeveloperId);
        specialty.setSpecialty(specialtyDeveloperConsole);

        List<Skill> skills = new ArrayList<>();

        // оптимизировать цикл мб
        for (int i =0;i<developerInputConsoleData.get("skills").split(",").length;i++ )
        {
            skills.add(new Skill());
            skills.get(i).setId(newDeveloperId);
            skills.get(i).setSkill(developerInputConsoleData.get("skills").split(",")[i]);// хз че тут происходит посмотреть коретно ли работает
        }


        FacadeModel facadeModel = new FacadeModel();
        facadeModel.addDataInModel(developer,specialty,skills);


    }

    public void readDataOfDeveloper() {

    }

    public void deleteDeveloper() {

    }

    public void updateDeveloper() {

    }


}
