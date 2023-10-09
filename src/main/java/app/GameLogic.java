package app;

import app.console_utils.ReaderConsole;
import app.console_utils.WriterConsole;

import java.util.*;

public class GameLogic {

    protected static void startGame() {
        WriterConsole startMessage = new WriterConsole();
        startMessage.outputValueConsole("Для начала игры введите start, при вводе любого другого слова игра завершиться");
    }

    protected static int inputCountPlayers() {
        int valueOfConsole;

        try {
            WriterConsole.outputValueConsole("Введите цифрой количество участников, принимаются только целые числа");
            valueOfConsole = ReaderConsole.readIntValueFromConsole();
        } catch (InputMismatchException e) {
            WriterConsole.outputValueConsole("Убедитесь что ввели число цифрой и повторите попытку");
            valueOfConsole = ReaderConsole.readIntValueFromConsole();

        }

        return valueOfConsole;
    }

    protected static ArrayList<Player> inputNamePlayers(ArrayList<Player> players, int countPlayers) {
        for (int i = 0; i < countPlayers; i++) {
            WriterConsole.outputValueConsole(String.format("Введите имя участника №%d", i + 1));
            players.add(new Player(ReaderConsole.readStringValueFromConsole()));
        }
        return players;
    }

    protected static void chooseElements(ArrayList<Player> players) {
        for (Player player : players) {
            WriterConsole.outputValueConsole(String.format("%s, выбери свой элемент", player.getNamePlayer()));
            player.setPlayerElement(ReaderConsole.readStringValueFromConsole());
        }
    }

    protected static ArrayList<Player> getWinnerRound(ArrayList<Player> players) {
        return FinderWinner.determineWinner(players);
    }


    protected static void outputWinnerMessage (ArrayList<Player> winnerTheRound) {
        WriterConsole.outputValueConsole(String.format("%s победил", winnerTheRound.get(0).getNamePlayer()));
    }
}
