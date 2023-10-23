package task_1_3.developer.developer_model;

import task_1_3.developer.GsonDeveloperRepositoryImpl;
import task_1_3.developer.developer_atribute.skills.GsonSkillRepositoryImpl;
import task_1_3.developer.developer_atribute.skills.Skill;
import task_1_3.developer.developer_atribute.specialty.GsonSpecialtyRepositoryImpl;
import task_1_3.developer.developer_atribute.specialty.Specialty;

import java.util.ArrayList;
import java.util.List;

public class FacadeModel {
    // статик класс сделать думаю объекты фасада не к чему
    public ArrayList<String> getDataAboutDeveloperModel() {
        return Developer.getFieldsDeveloperModel();
    }

    public void getAllDevelopersData () {
    }


    public void addDataInModel (Developer developer, Specialty specialty, List<Skill> skills){
        Developer developerData;
        developerData = developer;
        // узнаем id developer, и добавляем в таблицу skill и specialty его знначения
//        developerData.setSkills(skills);
//        developerData.setSpecialty(specialty);

        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();
        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

        // а сюда отдаем девелопера без специальности и скилов
        gsonDeveloperRepository.add(developerData);
        gsonSpecialtyRepository.addDataFromFileDeveloper(specialty);
        gsonSkillRepository.addDataFromFile(skills);
    }

}
