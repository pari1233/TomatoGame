package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExitGUI extends JFrame {

	private JPanel contentPane;

	private static final long serialVersionUID = -3795117086340444040L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExitGUI frame = new ExitGUI();
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
	public ExitGUI() {
		setTitle("Exit");
	    setSize(850, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel exitLbl = new JLabel("");
		exitLbl.setBackground(new Color(0, 0, 0));
		exitLbl.setIcon(new ImageIcon("Game/images/Bexit.png"));
		exitLbl.setBounds(348, 118, 128, 120);
		contentPane.add(exitLbl);
		
		JButton continueBtn = new JButton("Continue");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		MenuGUI menupage = new MenuGUI();	
        		menupage.setVisible(true);
			}
		});
		continueBtn.setHorizontalAlignment(SwingConstants.LEFT);
		continueBtn.setForeground(new Color(0, 0, 0));
		continueBtn.setBackground(new Color(176, 224, 230));
		continueBtn.setIcon(new ImageIcon("Game/images/continue.png"));
		continueBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 26));
		continueBtn.setBounds(115, 280, 267, 120);
		contentPane.add(continueBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0); // Exit the application
	            }
		});
		exitBtn.setBackground(new Color(250, 235, 215));
		exitBtn.setForeground(new Color(0, 0, 0));
		exitBtn.setHorizontalAlignment(SwingConstants.LEFT);
		exitBtn.setIcon(new ImageIcon("Game/images/quit.png"));
		exitBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 26));
		exitBtn.setBounds(449, 281, 287, 119);
		contentPane.add(exitBtn);
	}
}
