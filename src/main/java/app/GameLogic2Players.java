package app;

import app.console_utils.ReaderConsole;
import app.console_utils.WriterConsole;

import java.util.*;

public class GameLogic2Players {
    private final Field field = new Field();

    protected void startGame() {
        WriterConsole.outputValueConsole("Для начала игры введите start, при вводе любого другого слова игра завершиться");

        try {
            if (ReaderConsole.readStringValueFromConsole().equals("start")) {
                WriterConsole.outputValueConsole("Введите цифрой количество участников, принимаются только целые числа");
                int countPlayers = ReaderConsole.readIntValueFromConsole();

                ArrayList<Player> players;

                players = inputPlayersName(countPlayers);
                inputPlayerElements(players);

                FinderWinner finder = new FinderWinner();

                while (field.getPlayersElements().size() != 1) {
                    int countRound = 0;
                    WriterConsole.outputValueConsole(String.format("Раунд %d", countRound ++));
                    WriterConsole.outputValueConsole(String.format("%s, выбери свой элемент", players.get(0).getNamePlayer()));
                    field.setElements(players.get(0), getPlayerElementFromConsole());
                    WriterConsole.outputValueConsole(String.format("%s, выбери свой элемент",players.get(1).getNamePlayer()));
                    field.setElements(players.get(1), getPlayerElementFromConsole());
                    finder.checkWinnerRound();
                }

                String nameWinner = field.getPlayersElements().keySet().iterator().next().getNamePlayer();
                WriterConsole.outputValueConsole(String.format("Победитель %s", nameWinner));

            } else {
                WriterConsole.outputValueConsole("Игра завершена");
            }
        } catch (NullPointerException e) {
            WriterConsole.outputValueConsole("Ничья");
        }

    }


    private ArrayList<Player> inputPlayersName(int countPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        for (int player = 0; player < countPlayers; player++) {
            WriterConsole.outputValueConsole(String.format("Введите имя участника %d", player + 1));
            players.add(new Player(ReaderConsole.readStringValueFromConsole()));
        }
        return players;
    }

    private void inputPlayerElements(ArrayList<Player> players) {
        for (Player player : players) {
            WriterConsole.outputValueConsole(String.format("%s, выбери свой элемент", player.getNamePlayer()));
            field.setElements(player, getPlayerElementFromConsole());
        }
    }

    private Element getPlayerElementFromConsole() {
        String elementFromConsole = ReaderConsole.readStringValueFromConsole();
        if (elementFromConsole.equalsIgnoreCase("stone")) {
            return Element.STONE;
        } else if (elementFromConsole.equalsIgnoreCase("paper")) {
            return Element.PAPER;
        } else {
            return Element.SCISSORS;
        }
    }

    private class FinderWinner {
        public void checkWinnerRound() {
            SortedSet<Element> uniqueElements = new TreeSet<Element>();

            for (Map.Entry<Player, Element> player : field.getPlayersElements().entrySet()) {
                uniqueElements.add(player.getValue());
            }
            if (uniqueElements.size() == 2) {
                Element winnersElement = returnWinnerElement(uniqueElements.first(), uniqueElements.last());
                field.getPlayersElements().entrySet().removeIf(e -> !e.getValue().equals(winnersElement));
            } else if (uniqueElements.size() == 1) {
                field.getPlayersElements();
            } else {
                field.setElements();
            }
        }


        private Element returnWinnerElement(Element firstElement, Element secondElement) {

            if (firstElement == Element.STONE & secondElement == Element.PAPER) {
                return secondElement;
            } else if (firstElement == Element.PAPER & secondElement == Element.STONE) {
                return firstElement;
            } else if (firstElement == Element.PAPER & secondElement == Element.SCISSORS) {
                return secondElement;
            } else if (firstElement == Element.SCISSORS & secondElement == Element.PAPER) {
                return firstElement;
            } else if (firstElement == Element.STONE & secondElement == Element.SCISSORS) {
                return firstElement;
            } else if (firstElement == Element.SCISSORS & secondElement == Element.STONE) {
                return secondElement;
            } else {
                return secondElement;
            }
        }

    }

}


//                for (Map.Entry<Player, Element> player : field.getPlayersElements().entrySet()) {
//                    if (!player.getValue().equals(winnersElement)) {
//                        field.removeElements(player.getKey());
//                    }
//                }