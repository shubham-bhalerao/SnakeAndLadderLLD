package Models;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Integer, Square> squares;

    public Board(int size) {
        squares = new HashMap<>();
        for (int i = 1; i <= size; i++) {
            squares.put(i, new Square(i));
        }
    }

    public Square getSquare(int squareNumber) {
        return squares.get(squareNumber);
    }

    public void addSnake(int head, int tail) {
        squares.get(head).setNextSquare(tail);
    }

    public void addLadder(int base, int top) {
        squares.get(base).setNextSquare(top);
    }

    public int getSize() {
        return squares.size();
    }
}