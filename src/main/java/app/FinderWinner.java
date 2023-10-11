//package app;
//
//import app.console_utils.WriterConsole;
//
//import java.util.*;
//
//public class FinderWinner {
//    protected static ArrayList<Player> determineWinner(ArrayList<Player> players) {
//
//        for (Player player : players) {
//            player.editNamePlayer(player.getNamePlayer().toLowerCase());
//        }
//            return returnWinnerFromSetUsers(players);
//    }
//
//    private static ArrayList<Player> returnWinnerFromSetUsers(ArrayList<Player> players) {
//        ArrayList<Player> winners = new ArrayList<>();
//        SortedSet<String> uniqueElements = new TreeSet<String>();
//        HashMap<Player, String> playersAndElements = new HashMap<>();
//
//
//        for (Player player : players) {
////            uniqueElements.add(player.getPlayerElement());
////            playersAndElements.put(player, player.getPlayerElement());
//        }
//
////        ArrayList<String> uniqueElementsList = new ArrayList<>(uniqueElements);
//
//        if (uniqueElements.size() == 2) {
//            String winnersElement = returnWinnerElement(uniqueElements.first(), uniqueElements.last());
//            for (Map.Entry<Player, String> player : playersAndElements.entrySet()) {
//                if (player.getValue().equals(winnersElement)) {
//                    winners.add(player.getKey());
//                }
//            }
//        } else if (uniqueElements.size() == 1) {
//            return players;
//        } else {
//            winners=null;
//        }
//        return winners;
//    }
//
//    private static String returnWinnerElement(String firstElement, String secondElement) {
//
//        if (firstElement.equals("камень") & secondElement.equals("бумага")) {
//            return secondElement;
//        } else if (firstElement.equals("бумага") & secondElement.equals("камень")) {
//            return firstElement;
//        } else if (firstElement.equals("бумага") & secondElement.equals("ножницы")) {
//            return secondElement;
//        } else if (firstElement.equals("ножницы") & secondElement.equals("бумага")) {
//            return firstElement;
//        } else if (firstElement.equals("камень") & secondElement.equals("ножницы")) {
//            return firstElement;
//        } else if (firstElement.equals("ножницы") & secondElement.equals("камень")) {
//            return secondElement;
//        } else {
//            return secondElement;
//        }
//    }
//}
