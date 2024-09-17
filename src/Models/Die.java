package Models;

import java.util.Random;

public class Die {
    private static Die instance;

    private Die() {}

    public synchronized static Die getInstance() {
        if (instance == null) {
            instance = new Die();
        }
        return instance;
    }

    public int roll() {
        return new Random().nextInt(6) + 1;
    }
}