package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HelpGUI extends JFrame {

	private JPanel contentPane;

	private static final long serialVersionUID = -3795117086340444040L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpGUI frame = new HelpGUI();
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
	public HelpGUI() {
		setTitle("Help");
	    setSize(850, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Help");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("Game/images/Help.png"));
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 44));
		lblNewLabel.setBounds(335, 71, 203, 91);
		contentPane.add(lblNewLabel);
		
				
		JTextArea txtrDetailsSolve = new JTextArea();
		txtrDetailsSolve.setEditable(false);
		txtrDetailsSolve.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtrDetailsSolve.setWrapStyleWord(true);
		txtrDetailsSolve.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txtrDetailsSolve.setForeground(new Color(0, 64, 128));
        txtrDetailsSolve.setLineWrap(true);
        txtrDetailsSolve.setText(
                "\n\n" +
                        "    • Solve equations by figuring out the value of the tomato symbol ( ).\n" +
                        "    • Replace the tomato symbol with a number to make the equation true.\n" +
                        "    • Pay attention to operations and patterns, and double-check your calculations.\n" +
                        "    • Score points for each correct answer.\n" +
                        "    • Sharpen your math skills and let's play!");
        txtrDetailsSolve.setBounds(137, 173, 578, 179);
        contentPane.add(txtrDetailsSolve);
        
        JButton backBtn = new JButton("");
        backBtn.setForeground(new Color(255, 255, 255));
        backBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 12));
        backBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Design.playButtonClickSound();
        		setVisible(false);
        		MenuGUI menu = new MenuGUI();
        		menu.setVisible(true);
        	}
        });
        backBtn.setIcon(new ImageIcon("Game/images/Sback.png"));
        backBtn.setBounds(24, 11, 58, 64);
        contentPane.add(backBtn);
	}
	

}
