package task_1_3.developer.developer_model;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import task_1_3.developer.DeveloperController;
import task_1_3.developer.GsonDeveloperRepositoryImpl;
import task_1_3.developer.developer_atribute.skills.GsonSkillRepositoryImpl;
import task_1_3.developer.developer_atribute.skills.Skill;
import task_1_3.developer.developer_atribute.skills.SkillsController;
import task_1_3.developer.developer_atribute.skills.SkillsView;
import task_1_3.developer.developer_atribute.specialty.GsonSpecialtyRepositoryImpl;
import task_1_3.developer.developer_atribute.specialty.Specialty;
import task_1_3.developer.developer_atribute.specialty.SpecialtyController;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FacadeModel {
    // статик класс сделать думаю объекты фасада не к чему
    public ArrayList<String> getDataAboutDeveloperModel() {
        return Developer.getFieldsDeveloperModel();
    }

    public ArrayList<String> getDataAboutSkillModel() {
        return Skill.getFieldsSkillModel();
    }

    public ArrayList<String> getDataAboutSpecialtyModel() {
        return Specialty.getFieldsSpecialtyModel();
    }

    public static void readAlldata() throws IOException {
        String developerPath = "src/main/java/task_1_3/data/developer.json";
        String skillPath = "src/main/java/task_1_3/data/skills.json";
        String specialtyPath = "src/main/java/task_1_3/data/specialty.json";

        try (FileReader readerDev = new FileReader(developerPath); FileReader readerSpec = new FileReader(specialtyPath); FileReader readerSkill = new FileReader(skillPath)) {
            // Создаем объект Gson
            Gson gson = new Gson();

            // Десериализуем JSON массив в список объектов
            Developer[] developers = gson.fromJson(readerDev, Developer[].class);
            Specialty[] specialties = gson.fromJson(readerSpec, Specialty[].class);
            Skill[] skills = gson.fromJson(readerSkill, Skill[].class);

            // Преобразуем массив в список
            List<Developer> developersList = Arrays.asList(developers);
            List<Specialty> specialtiesList = Arrays.asList(specialties);
            List<Skill> skillsList = Arrays.asList(skills);


            for (int i = 0; i < developersList.size(); i++) {
                int devInd = developersList.get(i).getId();
                Specialty spec = SpecialtyController.getSpecById(specialtiesList, devInd);
                String skillsData = SkillsController.getSpecById(skillsList, devInd);
                System.out.println("id:" + developersList.get(i).getId() + ", firstName:" + developersList.get(i).getFirstName() + ", lastName:" + developersList.get(i).getLastName()
                        + ", specialty:" + spec.getSpecialty()+", skills:"+skillsData );
            }
        }
    }

    public static void createUserWithSkillSpecialty() {

        DeveloperController developerController = new DeveloperController();
        SpecialtyController specialtyController = new SpecialtyController();
        SkillsController skillsController = new SkillsController();

        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();
        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

        gsonDeveloperRepository.add(developerController.createDeveloper());
        int id = developerController.getNewDeveloperId();
        gsonSpecialtyRepository.add(specialtyController.createSpecialty(id));
        gsonSkillRepository.add(skillsController.createSkill(id));
    }

    public static void updateData() {

    }





    }
