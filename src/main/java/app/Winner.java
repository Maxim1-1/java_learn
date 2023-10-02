package app;

import java.util.*;

public class Winner {
    public ArrayList<Player> determineWinner(ArrayList<Player> players) {

        ArrayList<Player> winnerPlayers = new ArrayList<>();

        for (Player player : players) {
            player.setNamePlayer(player.getNamePlayer().toLowerCase());
        }

        if (players.size() == 2) {
            String winnerElement = returnWinner(players.get(0).getPlayerElement(), players.get(1).getPlayerElement());

            if (players.get(0).getPlayerElement().equals(winnerElement) & players.get(1).getPlayerElement().equals(winnerElement)) {
                winnerPlayers.add(players.get(0));
                winnerPlayers.add(players.get(1));
            } else if (players.get(0).getPlayerElement().equals(winnerElement)) {
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
        } else if (uniqueElementsList.size() == 1) {
            return players;
        } else {
            winners = null;
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
        } else if (firstElement.equals("ножницы") & secondElement.equals("камень")) {
            return winElement = secondElement;
        } else {
            return winElement = secondElement;
        }
    }
}
