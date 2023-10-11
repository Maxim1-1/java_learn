package app;

import java.util.HashMap;
import java.util.Map;

public class GameRunner {

    public static void main(String[] args) {
        GameLogic2Players gl = new GameLogic2Players();
        gl.startGame();


//        HashMap<Player, Element> test = new HashMap<>();
//        test.put(new Player("test"), Element.PAPER);
//        test.put(new Player("test1"), Element.PAPER);

//        Field field = new Field();
//        field.setElements(new Player("test"), Element.PAPER);
//        field.setElements(new Player("test1"), Element.STONE);
//        System.out.println(field.getPlayersElements());
//
//
//        field.getPlayersElements().entrySet().removeIf(e -> e.getValue()==Element.STONE);

//        for (Map.Entry<Player, Element> player : field.getPlayersElements().entrySet()) {
//
//                field.removeElements(player.getKey());
//
//        }

//        System.out.println(field.getPlayersElements());

    }

}
