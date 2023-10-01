package app;

import java.util.ArrayList;

public class PlayerFactory {

    public ArrayList<Player> createPlayers (int countPlayers) {
        ArrayList<Player> list = new ArrayList<>();

        for (int i=0;i<countPlayers;i++) {
            list.add(new Player());
        }
        return list;
    }
}
