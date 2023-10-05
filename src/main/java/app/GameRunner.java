package app;

import app.console_utils.Reader;
import app.console_utils.Writer;

import java.util.ArrayList;

public class GameRunner {

    public static void main(String[] args) {

        int counterRound =1;

        Reader readerConsole = new Reader();
        Writer writerConsole = new Writer();
        GameLogic gameLogic = new GameLogic();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> winnerTheRound;

        gameLogic.start();

        if (readerConsole.getValueFromConsole().equals("start")) {
            players = gameLogic.inputAndCreatePlayers();

        } else {
            writerConsole.outputValueConsole("игра завершена");
        }

        System.out.printf("Раунд %s%n", counterRound);
        gameLogic.chooseElements(players);
        winnerTheRound = Winner.determineWinner(players);

        for (int round = 0; winnerTheRound.size()!=1; round++) {
            System.out.printf("Раунд %s%n", counterRound +1);
            gameLogic.chooseElements(winnerTheRound);
            winnerTheRound = Winner.determineWinner(winnerTheRound);
        }
        writerConsole.outputValueConsole(String.format("%s победил", winnerTheRound.get(0).namePlayer));

    }
}
