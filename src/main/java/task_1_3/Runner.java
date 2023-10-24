package task_1_3;

import task_1_3.developer.DeveloperController;
import task_1_3.developer.DeveloperView;
import task_1_3.developer.GsonDeveloperRepositoryImpl;
import task_1_3.developer.developer_model.Developer;
import task_1_3.developer.developer_model.FacadeModel;
import task_1_3.developer.developer_utils.DeveloperUtils;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        DeveloperController developerUtils = new DeveloperController();
        developerUtils.getCommandConsole();
//        FacadeModel facadeModel = new FacadeModel();
//        facadeModel.readAlldata();
//        System.out.println(developerUtils.getMaxIdFromDeveloperJson());

        GsonDeveloperRepositoryImpl test = new GsonDeveloperRepositoryImpl();

//        test.addDataFromFileDeveloper();
//        System.out.println();

    }
}
