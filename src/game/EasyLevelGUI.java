package game;
import javax.swing.*;

import engine.Game;
import engine.GameEngine;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class EasyLevelGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -3795117086340444040L;
    private JPanel contentPane;

    private JLabel questArea = null;
    private JTextArea infoArea = null;
    private GameEngine myGame = null;
    private int currentGameIndex = 0;
    private int totalScore = 0;
    private int[] questionScores = new int[5];
    private int answerAttempts = 0;
    private Timer gameTimer;

    public EasyLevelGUI() {
        setTitle("Easy Level");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        contentPane = new JPanel(new BorderLayout());
        setLocationRelativeTo(null);
        myGame = new GameEngine("Player");

        loadNextGame();

        getContentPane().add(contentPane);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadNextGame() {
        if (currentGameIndex >= 5) {
            endLevel();
            return;
        }

        contentPane.removeAll();

        BufferedImage gameImage = myGame.nextGame();
        Game currentGame = myGame.getCurrentGame();

        questArea = new JLabel(new ImageIcon(gameImage));
        questArea.setFont(new Font("Baskerville Old Face", Font.BOLD, 11));
        questArea.setBackground(new Color(0, 0, 0));
        contentPane.add(questArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 5));
        for (int j = 0; j < 10; j++) {
            JButton btn = new JButton(String.valueOf(j));
            btn.addActionListener(this);
        	Design.playButtonClickSound();
            buttonPanel.add(btn);
        }
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        infoArea = new JTextArea(2, 40);
        infoArea.setBackground(new Color(215, 0, 0));
        infoArea.setForeground(new Color(255, 255, 255));
        infoArea.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        infoArea.setEditable(false);
        infoArea.setText("What is the value of the tomato?   Score: 0   Time Left: 40"); // Include time left
        contentPane.add(infoArea, BorderLayout.NORTH);

        gameTimer = new Timer(1000, new ActionListener() {
            int timeLeft = 40;

            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                infoArea.setText("What is the value of the tomato?   Score: " + totalScore + "   Time Left: " + timeLeft); // Update time left
                if (timeLeft == 0) {
                    gameTimer.stop();
                    handleTimeout();
                }
            }
        });
        gameTimer.start();
        answerAttempts = 0;
    }

    private void endLevel() {
        StringBuilder scoreText = new StringBuilder("Level completed!\nQuestion Scores:\n");
        for (int i = 0; i < 5; i++) {
            scoreText.append("Question ").append(i + 1).append(": ").append(questionScores[i]).append("\n");
        }
        scoreText.append("Total Score: ").append(totalScore);
        JOptionPane.showMessageDialog(this, scoreText.toString());
        dispose();
        setVisible(false);
        new Scoreboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        answerAttempts++;
        JButton button = (JButton) e.getSource();
        int answer = Integer.parseInt(button.getText());

        boolean correct = myGame.checkSolution(answer);
        if (correct || answerAttempts >= 5) {
            int correctAnswer = myGame.getCurrentGame().getSolution();
            infoArea.setText("Correct answer is: " + correctAnswer + ". Score: " + totalScore);
            questionScores[currentGameIndex] = calculateScore();
            totalScore += questionScores[currentGameIndex];
            currentGameIndex++;
            gameTimer.stop();
            loadNextGame();
           
        }
    }

    private void handleTimeout() {
        int correctAnswer = myGame.getCurrentGame().getSolution();
        if (answerAttempts < 5) {
            infoArea.setText("Time Over! Correct answer is: " + correctAnswer + ". Score: " + totalScore);
            questionScores[currentGameIndex] = 0;
            totalScore += questionScores[currentGameIndex];
            setVisible(false);
            new Scoreboard().setVisible(true);
        } else {
            questionScores[currentGameIndex] = calculateScore();
            totalScore += questionScores[currentGameIndex];
        }
        currentGameIndex++;
        loadNextGame();
    }

    private int calculateScore() {
        switch (answerAttempts) {
            case 0:
                return 10;
            case 1:
                return 8;
            case 2:
                return 6;
            case 3:
                return 4;
            case 4:
                return 2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EasyLevelGUI::new);
    }
}
