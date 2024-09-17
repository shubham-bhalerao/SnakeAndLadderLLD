package Models;

// Models.Square class for each board cell
public class Square {
    private int number;
    private int nextSquare;  // For ladders or snakes, otherwise, it's the same square.

    public Square(int number) {
        this.number = number;
        this.nextSquare = number;
    }

    public int getNumber() {
        return number;
    }

    public int getNextSquare() {
        return nextSquare;
    }

    public void setNextSquare(int nextSquare) {
        this.nextSquare = nextSquare;
    }
}