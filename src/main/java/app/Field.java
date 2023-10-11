package app;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private Map<Player,Element> playersElements=new HashMap<>();

    public Map<Player, Element> getPlayersElements() {
        return playersElements;
    }

    public void setElements(Player player, Element element) {
        playersElements.put(player,element);
    }
    public void setElements() {
        playersElements = null;
    }
    public void removeElements (Player player) {
        playersElements.remove(player);
    }




}
