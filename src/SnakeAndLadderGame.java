import Factories.BoardFactory;
import Models.Board;
import Models.Player;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        Board board = BoardFactory.createStandardBoard();
        game.initBoard(board);

        // Add players
        game.addPlayer(new Player(1, "Models.Player 1"));
        game.addPlayer(new Player(2, "Models.Player 2"));

        // Start the game
        game.startGame();
    }
}