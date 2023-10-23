package task_1_3.base;

import java.util.Scanner;

public class Controller {

    public String getStringValueFromConsole () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
