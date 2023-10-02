package app;


public class Player {

    String namePlayer;
    String playerElement;

    public String getPlayerElement() {
        return playerElement;
    }

    public void setPlayerElement(String playerElement) {
        this.playerElement = playerElement;
    }

    Player (String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getNamePlayer() {
        return this.namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

}