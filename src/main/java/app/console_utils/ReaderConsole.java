package app.console_utils;
import java.util.Scanner;

public class ReaderConsole {
    public static String readStringValueFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readIntValueFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
