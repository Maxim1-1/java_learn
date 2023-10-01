package app;

import app.console_utils.Reader;
import app.console_utils.Writer;

import java.util.*;

public class GameLogic {

    public void start() {
        Writer startMessage = new Writer();
        startMessage.outputValueConsole("Для начала игры введите start");
    }

    public ArrayList<Player> inputAndCreatePlayers() {
        Reader readerConsole = new Reader();
        Writer writerConsole = new Writer();
        PlayerFactory playersFactory = new PlayerFactory();
        ArrayList<Player> players;

        writerConsole.outputValueConsole("Введите цифрой количество участников");
        players = playersFactory.createPlayers(Integer.parseInt(readerConsole.getValueFromConsole()));

        for (int i = 0; i < players.size(); i++) {
            writerConsole.outputValueConsole(String.format("Введите имя участника участника №%d", i + 1));
            players.get(i).setNamePlayer(readerConsole.getValueFromConsole());
        }
        return players;
    }

    public void chooseElements(ArrayList<Player> players) {
        Writer writerConsole = new Writer();
        Reader readerConsole = new Reader();

        for (Player player : players) {
            writerConsole.outputValueConsole(String.format("%s, выбери свой элемент", player.getNamePlayer()));
            player.setPlayerElement(readerConsole.getValueFromConsole());
        }
    }

    public ArrayList<Player> determineWinner(ArrayList<Player> players) {

        ArrayList<Player> winnerPlayers = new ArrayList<>();

        for (Player player : players) {
            player.setNamePlayer(player.getNamePlayer().toLowerCase());
        }

        if (players.size() == 2) {
            String winnerElement = returnWinner(players.get(0).getPlayerElement(), players.get(1).getPlayerElement());
            if (players.get(0).getPlayerElement().equals(winnerElement)) {
                winnerPlayers.add(players.get(0));
            } else {
                winnerPlayers.add(players.get(1));
            }
            return winnerPlayers;

        } else {
            return returnWinnerFromSetUsers(players);

        }
    }

    private ArrayList<Player> returnWinnerFromSetUsers(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        Set<String> uniqueElements = new HashSet<>();
        HashMap<Player, String> playersAndElements = new HashMap<>();


        for (int i = 0; i < players.size(); i++) {
            uniqueElements.add(players.get(i).getPlayerElement());
        }

        for (int i = 0; i < players.size(); i++) {
            playersAndElements.put(players.get(i), players.get(i).getPlayerElement());
        }

        ArrayList<String> uniqueElementsList = new ArrayList<>(uniqueElements);

        if (uniqueElementsList.size() == 2) {
            String winnersElement = returnWinner(uniqueElementsList.get(0), uniqueElementsList.get(1));
            for (Map.Entry<Player, String> player : playersAndElements.entrySet()) {
                if (player.getValue().equals(winnersElement)) {
                    winners.add(player.getKey());
                }
            }

        } else {
            winners=null;
            System.out.println("ничья, игра окончена");
        }
        return winners;
    }


    private String returnWinner(String firstElement, String secondElement) {
        String winElement;

        if (firstElement.equals("камень") & secondElement.equals("бумага")) {
            return winElement = secondElement;
        } else if (firstElement.equals("бумага") & secondElement.equals("камень")) {
            return winElement = firstElement;
        } else if (firstElement.equals("бумага") & secondElement.equals("ножницы")) {
            return winElement = secondElement;
        } else if (firstElement.equals("ножницы") & secondElement.equals("бумага")) {
            return winElement = firstElement;
        } else if (firstElement.equals("камень") & secondElement.equals("ножницы")) {
            return winElement = firstElement;
        } else {
            return winElement = secondElement;
        }
    }

    private void removePlayer(ArrayList<Player> players, Player player) {
        players.remove(player);
    }

}


//    protected Player returnWinner(String firstElement, String secondElement) {
//        String winElement;
//
//
//        if (firstElement.equals("камень") & secondElement.equals("бумага")) {
//            return secondPlayer;
//        } else if (firstElement.equals("бумага") & secondElement.equals("камень")) {
//            return firstElement;
//        } else if (firstElement.equals("бумага") & secondElement.equals("ножницы")) {
//            return secondPlayer;
//        } else if (firstElement.equals("ножницы") & secondElement.equals("бумага")) {
//            return firstElement;
//        } else if (firstElement.equals("камень") & secondElement.equals("ножницы")) {
//            return firstElement;
//        } else {
//            return secondPlayer;
//        }
//    }