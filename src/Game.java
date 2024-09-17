import Models.Board;
import Models.Die;
import Models.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game instance;
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private boolean isGameOver;

    private Game() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.isGameOver = false;
    }

    public synchronized static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void initBoard(Board board) {
        this.board = board;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        if (board == null || players.isEmpty()) {
            throw new IllegalStateException("Game not properly initialized");
        }

        System.out.println("Game Started!");
        while (!isGameOver) {
            playTurn();
        }
    }

    private void playTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        if ("inactive".equals(currentPlayer.getPosition())) {
            nextTurn();
            return;
        }

        int roll = Die.getInstance().roll();
        System.out.println(currentPlayer.getName() + " rolled a " + roll);
        int newPosition = currentPlayer.getPosition() + roll;

        if (newPosition > board.getSize()) {
            System.out.println(currentPlayer.getName() + " can't move, roll exceeded board size.");
            nextTurn();
            return;
        }

        newPosition = board.getSquare(newPosition).getNextSquare();
        currentPlayer.setPosition(newPosition);

        if (newPosition == board.getSize()) {
            System.out.println(currentPlayer.getName() + " wins the game!");
            isGameOver = true;
            return;
        }

        nextTurn();
    }

    private void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}