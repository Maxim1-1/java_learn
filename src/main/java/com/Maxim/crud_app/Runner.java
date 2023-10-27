package com.Maxim.crud_app;

//import com.Maxim.crudapp.base.controller.DeveloperController;

public class Runner {
    public static void main(String[] args)  {

        UserCommandHandler userController = new UserCommandHandler();
        userController.getCommandConsole();

    }
}



