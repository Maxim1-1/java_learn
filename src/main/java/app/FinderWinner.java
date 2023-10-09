package app;

import app.console_utils.WriterConsole;

import java.util.*;

public class FinderWinner {
    protected static ArrayList<Player> determineWinner(ArrayList<Player> players) {

        for (Player player : players) {
            player.editNamePlayer(player.getNamePlayer().toLowerCase());
        }
            return returnWinnerFromSetUsers(players);
    }

    private static ArrayList<Player> returnWinnerFromSetUsers(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        Set<String> uniqueElements = new HashSet<>();
        HashMap<Player, String> playersAndElements = new HashMap<>();


        for (Player player : players) {
            uniqueElements.add(player.getPlayerElement());
            playersAndElements.put(player, player.getPlayerElement());
        }

        ArrayList<String> uniqueElementsList = new ArrayList<>(uniqueElements);

        if (uniqueElementsList.size() == 2) {
            String winnersElement = returnWinnerElement(uniqueElementsList.get(0), uniqueElementsList.get(1));
            for (Map.Entry<Player, String> player : playersAndElements.entrySet()) {
                if (player.getValue().equals(winnersElement)) {
                    winners.add(player.getKey());
                }
            }
        } else if (uniqueElementsList.size() == 1) {
            return players;
        } else {
            winners=null;
        }
        return winners;
    }

    private static String returnWinnerElement(String firstElement, String secondElement) {

        if (firstElement.equals("камень") & secondElement.equals("бумага")) {
            return secondElement;
        } else if (firstElement.equals("бумага") & secondElement.equals("камень")) {
            return firstElement;
        } else if (firstElement.equals("бумага") & secondElement.equals("ножницы")) {
            return secondElement;
        } else if (firstElement.equals("ножницы") & secondElement.equals("бумага")) {
            return firstElement;
        } else if (firstElement.equals("камень") & secondElement.equals("ножницы")) {
            return firstElement;
        } else if (firstElement.equals("ножницы") & secondElement.equals("камень")) {
            return secondElement;
        } else {
            return secondElement;
        }
    }
}
