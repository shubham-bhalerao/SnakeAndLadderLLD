package Observers;

public class PlayerObserver implements GameObserver {
    private String playerName;

    public PlayerObserver(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void update(String message) {
        System.out.println(playerName + " received update: " + message);
    }
}