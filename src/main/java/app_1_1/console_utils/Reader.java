package app_1_1.console_utils;
import java.util.Scanner;

public class Reader {
    public String getValueFromConsole () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}