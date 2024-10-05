package engine;

import java.awt.image.BufferedImage;

public class GameEngine {
    private String thePlayer;
    private int score;
    private GameServer theGames;
    private Game current;
    private int currentGameCount;

    public GameEngine(String player) {
        this.thePlayer = player;
        this.score = 0;
        this.theGames = new GameServer();
        this.current = null;
        this.currentGameCount = 0;
    }

    public BufferedImage nextGame() {
        current = theGames.getRandomGame();
        return current.getImage();
    }

    public boolean checkSolution(int i) {
        if (i == current.getSolution()) {
            score++;
            return true;
        } else {
            return false;
        }
    }

    public int getScore() {
        return score;
    }

    public int getCurrentGameCount() {
        return currentGameCount;
    }

    public void incrementGameCount() {
        currentGameCount++;
    }

    public void resetScore() {
        score = 0;
    }
    public Game getCurrentGame() {
        return current;
    }

}
