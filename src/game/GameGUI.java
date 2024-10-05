package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import engine.GameEngine;

import java.awt.Font;

public class GameGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -3795117086340444040L;
    private JPanel contentPane;

    JLabel questArea = null;
    GameEngine myGame = null;
    BufferedImage currentGame = null;
    JLabel scoreLbl = null; // Declare score label
    JLabel commentLbl = null; // Declare comment label

    @Override
    public void actionPerformed(ActionEvent e) {
        int solution = Integer.parseInt(((JButton)e.getSource()).getText());
        boolean correct = myGame.checkSolution(solution);
        if (correct) {
            System.out.println("Correct solution entered!");
            currentGame = myGame.nextGame();
            ImageIcon ii = new ImageIcon(currentGame);
            questArea.setIcon(ii);
            commentLbl.setText("Good job!"); // Display a generic positive comment
            updateScore(); // Update the score
        } else {
            System.out.println("Not Correct");
            commentLbl.setText("Oops. Try again!");
        }
    }

    private void updateScore() {
        int currentScore = Integer.parseInt(scoreLbl.getText().substring(7)); // Extract the current score from the score label
        int newScore = currentScore + 1; // Increment the score by 1
        scoreLbl.setText("Score: " + newScore); // Update the score label with the new score
    }

    private void initGame(String player) {
        setSize(780, 624);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("What is the missing value?");
        JPanel panel = new JPanel();

        myGame = new GameEngine(player);
        currentGame = myGame.nextGame();
        panel.setLayout(null);

        ImageIcon ii = new ImageIcon(currentGame);

        JScrollPane questPane = new JScrollPane();
        questPane.setBounds(43, 154, 662, 362);
        panel.add(questPane);
        questArea = new JLabel(ii);
        questPane.setRowHeaderView(questArea);
        
        int buttonWidth = 60; // Adjust the width of each button
        int buttonHeight = 40; // Adjust the height of each button
        int startX = 30; // X-coordinate of the starting position of the buttons
        int startY = 530; // Y-coordinate of the starting position of the buttons
        int gap = 10;// Gap between buttons
        
        Font buttonFont = new Font("Arial", Font.BOLD, 45);
        
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.setBounds(startX + i * (buttonWidth + gap), startY, buttonWidth, buttonHeight);
            panel.add(btn);
            btn.addActionListener(this);
        }

        getContentPane().add(panel);
        
        scoreLbl = new JLabel("Score: 0"); // Initialize score label
        scoreLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        scoreLbl.setBounds(323, 61, 107, 29);
        panel.add(scoreLbl);
        
        JLabel timeLbl = new JLabel("Time :");
        timeLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        timeLbl.setBounds(543, 61, 107, 29);
        panel.add(timeLbl);
        
        JLabel lifesLbl = new JLabel("Lifes :");
        lifesLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        lifesLbl.setBounds(67, 61, 76, 29);
        panel.add(lifesLbl);
        
        commentLbl = new JLabel("");
        commentLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        commentLbl.setHorizontalAlignment(SwingConstants.CENTER);
        commentLbl.setBounds(43, 101, 662, 26);
        panel.add(commentLbl);
        panel.repaint();
    }

    public GameGUI() {
        super();
        initGame(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI myGUI = new GameGUI();
            myGUI.setVisible(true);
        });
    }
}

