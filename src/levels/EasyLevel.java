package levels;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import engine.GameEngine;

public class EasyLevel {
    private static final int NUM_GAMES = 5;
    private static final int TIME_LIMIT_SECONDS= 40;

    private GameEngine gameEngine;
    private int totalScore;

    public EasyLevel() {
        gameEngine = new GameEngine("Player");
        totalScore = 0;
    }

    public void play() {
        for (int i = 0; i < NUM_GAMES; i++) {
            int remainingTime = TIME_LIMIT_SECONDS;
            int numIncorrectAnswers = 0;

            while (remainingTime > 0) {
                // Display game image to user
                displayGameImage();

                // Get user input and validate answer
                int userAnswer = getUserAnswer();
                boolean correct = gameEngine.checkSolution(userAnswer);
                if (!correct) {
                    numIncorrectAnswers++;
                }

                // Update score based on number of incorrect answers
                updateScore(numIncorrectAnswers);

                // Reduce remaining time
                remainingTime -= 5; // Assuming each answer takes 5 seconds
            }
        }

        // Display total score to user
        displayTotalScore();
    }

    private void displayGameImage() {
    	 BufferedImage gameImage = gameEngine.nextGame();

    	    // Display the game image to the user (you need to implement this part)
    	    // For example, you can use a JLabel to display the image in a JFrame
    	    // Here's a basic example:
    	    ImageIcon icon = new ImageIcon(gameImage);
    	    JLabel imageLabel = new JLabel(icon);
    	    JOptionPane.showMessageDialog(null, imageLabel, "Game Image", JOptionPane.PLAIN_MESSAGE);
    }

    private int getUserAnswer() {
        // Get user input for answer
        return 0; // Placeholder, replace with actual user input
    }

    private void updateScore(int numIncorrectAnswers) {
        if (numIncorrectAnswers == 0) {
            totalScore += 10;
        } else{
            totalScore += (10 - (numIncorrectAnswers * 2));
        }
    }

    private void displayTotalScore() {
        // Display total score to user
    }
}
