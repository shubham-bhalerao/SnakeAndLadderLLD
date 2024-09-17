package Models;

import Observers.GameObserver;
import Observers.PlayerObserver;

public class Player implements GameObserver {
        private int playerId;
        private String name;
        private int position;
        private String status;  // active or inactive
        private GameObserver observer;

        public Player(int playerId, String name) {
                this.playerId = playerId;
                this.name = name;
                this.position = 0;  // start at the beginning
                this.status = "active";
                this.observer = new PlayerObserver(name);
        }

        public int getPosition() {
                return position;
        }

        public void setPosition(int position) {
                this.position = position;
                observer.update(name + " moved to position " + position);
        }

        public String getName() {
                return name;
        }

        @Override
        public void update(String message) {
                System.out.println("[" + name + "]: " + message);
        }
}