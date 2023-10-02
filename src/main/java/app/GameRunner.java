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
        Winner winnerPair = new Winner();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> winnerTheGame;

        gameLogic.start();

        if (readerConsole.getValueFromConsole().equals("start")) {
            players = gameLogic.inputAndCreatePlayers();

        } else {
            writerConsole.outputValueConsole("игра завершена");
        }

        System.out.printf("Раунд %s%n", counterRound);
        gameLogic.chooseElements(players);
        winnerTheGame = winnerPair.determineWinner(players);

        for (int round = 0; winnerTheGame.size()!=1; round++) {
            System.out.printf("Раунд %s%n", counterRound +1);
            gameLogic.chooseElements(winnerTheGame);
            winnerTheGame = winnerPair.determineWinner(winnerTheGame);
        }
        writerConsole.outputValueConsole(String.format("%s победил", winnerTheGame.get(0).namePlayer));

    }
}
