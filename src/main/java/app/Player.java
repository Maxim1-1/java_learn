package app;


public class Player {
    protected void editNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    private String namePlayer;
    private Element playerElement;

    Player(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getNamePlayer() {
        return this.namePlayer;
    }

}