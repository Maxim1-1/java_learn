package app;

import app.console_utils.Reader;
import app.console_utils.Writer;

import java.util.ArrayList;

public class GameRunner {

    public static void main(String[] args) {
        Reader readerConsole = new Reader();
        Writer writerConsole = new Writer();
        GameLogic gameLogic = new GameLogic();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> winner = new ArrayList<>();

        gameLogic.start();
        if (readerConsole.getValueFromConsole().equals("start")) {
            players = gameLogic.inputAndCreatePlayers();

        } else {
            writerConsole.outputValueConsole("игра завершена");
        }

        for (int round = 0; winner.size()!=1; round++) {
            System.out.printf("Раунд %s%n", round +1);
            gameLogic.chooseElements(players);
            winner = gameLogic.determineWinner(players);
        }

    }
}
