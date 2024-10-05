package levels;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import engine.GameEngine;

public class HardLevel {
    private static final int NUM_GAMES = 5;
    private static final int TIME_LIMIT_SECONDS = 20;

    private GameEngine gameEngine;
    private int currentGameIndex;
    private BufferedImage[] gameImages;

    public HardLevel() {
        gameEngine = new GameEngine("Player");
        currentGameIndex = 0;
        gameImages = new BufferedImage[NUM_GAMES];
        loadGameImages();
    }

    private void loadGameImages() {
        for (int i = 0; i < NUM_GAMES; i++) {
            gameImages[i] = gameEngine.nextGame();
        }
    }

    public BufferedImage getNextGameImage() {
        BufferedImage nextImage = gameImages[currentGameIndex];
        return nextImage;
    }

    public static int getNumGames() {
        return NUM_GAMES;
    }

    public static int getTimeLimitSeconds() {
        return TIME_LIMIT_SECONDS;
    }

    public boolean checkAnswer(int userAnswer) {
        boolean correct = gameEngine.checkSolution(userAnswer);
        if (correct || currentGameIndex == NUM_GAMES - 1) {
            currentGameIndex++;
            return true;
        }
        return false;
    }
}
