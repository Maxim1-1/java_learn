package app;

import app.console_utils.ReaderConsole;
import app.console_utils.WriterConsole;

import java.util.ArrayList;

public class GameRunner {

    public static void main(String[] args) {

        GameLogic.startGame();

        if (ReaderConsole.readStringValueFromConsole().equals("start")) {
            ArrayList<Player> players = new ArrayList<>();
            ArrayList<Player> winnerTheRound;

            int countPlayers = GameLogic.inputCountPlayers();

            players = GameLogic.inputNamePlayers(players, countPlayers);
            winnerTheRound = players;

            try {

                for (int round = 1; winnerTheRound.size() != 1; round++) {
                    WriterConsole.outputValueConsole(String.format("Раунд %s", round));
                    GameLogic.chooseElements(winnerTheRound);
                    winnerTheRound = GameLogic.getWinnerRound(winnerTheRound);
                }

                GameLogic.outputWinnerMessage(winnerTheRound);
            } catch (NullPointerException e) {
                WriterConsole.outputValueConsole("Ничья");
            }

        } else {
            WriterConsole.outputValueConsole("игра завершена");
        }
    }

}
