package Factories;

import Models.Board;

public class BoardFactory {
    public static Board createStandardBoard() {
        Board board = new Board(100);
        board.addSnake(99, 21);
        board.addSnake(87, 36);
        board.addSnake(56, 7);
        board.addLadder(3, 22);
        board.addLadder(5, 8);
        board.addLadder(20, 29);
        return board;
    }
}