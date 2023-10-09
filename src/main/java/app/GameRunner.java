package app;

import app.console_utils.ReaderConsole;
import app.console_utils.WriterConsole;
import java.util.ArrayList;

public class GameRunner {

    public static void main(String[] args) {
        int counterRound = 1;

        GameLogic.startGame();
        if (ReaderConsole.readStringValueFromConsole().equals("start")) {
            ArrayList<Player> players = new ArrayList<>();
            ArrayList<Player> winnerTheRound=players;

            int countPlayers = GameLogic.inputCountPlayers();

            players = GameLogic.inputNamePlayers(players, countPlayers);
            winnerTheRound = players;

//            System.out.printf("Раунд %s%n", counterRound);
//            GameLogic.chooseElements(players);
//            winnerTheRound = FinderWinner.determineWinner(players);

            for (int round = 0; winnerTheRound.size() != 1; round++) {
                System.out.printf("Раунд %s%n", counterRound + 1);
                GameLogic.chooseElements(winnerTheRound);
                winnerTheRound = FinderWinner.determineWinner(winnerTheRound);
            }
        GameLogic.outputWinnerMessage(winnerTheRound);

        } else {
            WriterConsole.outputValueConsole("игра завершена");
        }
    }

}
