package app;


public class Player {
    protected void editNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    private String namePlayer;
    private String playerElement;

    public String getPlayerElement() {
        return playerElement;
    }

    public void setPlayerElement(String playerElement) {
        this.playerElement = playerElement;
    }

    Player(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getNamePlayer() {
        return this.namePlayer;
    }

}