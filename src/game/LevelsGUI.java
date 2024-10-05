package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class LevelsGUI extends JFrame {
	private static final long serialVersionUID = -3795117086340444040L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelsGUI frame = new LevelsGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelsGUI() {
		setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton easyBtn = new JButton("Easy");
		easyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Design.playButtonClickSound();
				setVisible(false);
				EasyLevelGUI easy = new EasyLevelGUI();
				easy.setVisible(true);
			}
		});
		easyBtn.setForeground(new Color(255, 255, 255));
		easyBtn.setBackground(new Color(0, 128, 0));
		easyBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		easyBtn.setBounds(294, 92, 208, 68);
		contentPane.add(easyBtn);
		
		JButton mediumBtn = new JButton("Medium");
		mediumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Design.playButtonClickSound();
        		setVisible(false);
				MediumLevelGUI medium = new MediumLevelGUI();
				medium.setVisible(true);
			}
		});
		mediumBtn.setForeground(new Color(255, 255, 255));
		mediumBtn.setBackground(new Color(255, 165, 0));
		mediumBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		mediumBtn.setBounds(294, 171, 208, 68);
		contentPane.add(mediumBtn);
		
		JButton hardBtn = new JButton("Hard");
		hardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Design.playButtonClickSound();
        		setVisible(false);
				HardLevelGUI hard = new HardLevelGUI();
				hard.setVisible(true);
			}
		});
		hardBtn.setForeground(new Color(255, 255, 255));
		hardBtn.setBackground(new Color(255, 0, 0));
		hardBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		hardBtn.setBounds(294, 257, 208, 68);
		contentPane.add(hardBtn);
		
		JLabel lblNewLabel = new JLabel("Levels");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
		lblNewLabel.setBounds(341, 25, 161, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Design.playButtonClickSound();
        		setVisible(false);
				MenuGUI menu = new MenuGUI();
				menu.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("Game/images/Sback.png"));
		btnNewButton_1.setBounds(24, 25, 63, 57);
		contentPane.add(btnNewButton_1);
		
		JButton scoreBoardBtn = new JButton("Score Board");
		scoreBoardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Design.playButtonClickSound();
        		setVisible(false);
				Scoreboard score = new Scoreboard();
				score.setVisible(true);
			}
		});
		scoreBoardBtn.setForeground(new Color(0, 0, 0));
		scoreBoardBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		scoreBoardBtn.setBackground(new Color(210, 180, 140));
		scoreBoardBtn.setBounds(294, 348, 208, 68);
		contentPane.add(scoreBoardBtn);
	}
}
