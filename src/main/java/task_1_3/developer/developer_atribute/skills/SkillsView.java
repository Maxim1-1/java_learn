package task_1_3.developer.developer_atribute.skills;

import task_1_3.developer.developer_model.FacadeModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SkillsView {
    private HashMap<String, String> outputSkillData = new HashMap<>();

    public HashMap<String, String> getOutputSkillData() {
        return outputSkillData;
    }

    public void create() {
        FacadeModel facadeModel = new FacadeModel();

        ArrayList<String> dataSkillModel = facadeModel.getDataAboutSkillModel();

        System.out.println("Введите скилы через запятую");
        Scanner scanner = new Scanner(System.in);
        outputSkillData.put(dataSkillModel.get(0), scanner.nextLine());


    }
}
