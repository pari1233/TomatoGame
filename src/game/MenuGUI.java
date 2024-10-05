package game;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuGUI extends JFrame {
	
	private static final long serialVersionUID = -3795117086340444040L;

	public static void main(String[] args) {
		MenuGUI menu = new MenuGUI();
        menu.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MenuGUI() {
		getContentPane().setBackground(new Color(0, 0, 0));
		setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        
        JButton startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Design.playButtonClickSound();
				setVisible(false);
        		LevelsGUI levels = new LevelsGUI();
        		levels.setVisible(true);
        	}
        });
        startBtn.setIcon(new ImageIcon("Game/images/start.png"));
        startBtn.setBackground(new Color(192, 192, 192));
        startBtn.setForeground(new Color(0, 0, 0));
        startBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 42));
        startBtn.setBounds(146, 130, 261, 129);
        getContentPane().add(startBtn);
        
        JButton exitBtn = new JButton("");
        exitBtn.setBackground(new Color(0, 0, 0));
        exitBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Design.playButtonClickSound();
				setVisible(false);
        		ExitGUI exit = new ExitGUI();
                exit.setVisible(true);
        	}
        });
        exitBtn.setIcon(new ImageIcon("Game/images/Exit.png"));
        exitBtn.setBounds(768, 0, 66, 66);
        getContentPane().add(exitBtn);
        
        JButton helpBtn = new JButton("Help");
        helpBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Design.playButtonClickSound();
        		setVisible(false);
        		HelpGUI helppage = new HelpGUI();	
        		helppage.setVisible(true);
        	}
        });
        helpBtn.setForeground(new Color(0, 0, 0));
        helpBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 42));
        helpBtn.setBackground(new Color(231, 181, 31));
        helpBtn.setIcon(new ImageIcon("Game/images/Help.png"));
        helpBtn.setBounds(412, 130, 261, 129);
        getContentPane().add(helpBtn);
        
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Design.playButtonClickSound();
        		setVisible(false);
        		SettingsGUI settingPage = new SettingsGUI();	
        		settingPage.setVisible(true);
        	}
        });
        settingsBtn.setIcon(new ImageIcon("Game/images/settings.png"));
        settingsBtn.setForeground(Color.BLACK);
        settingsBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 42));
        settingsBtn.setBackground(new Color(95, 158, 160));
        settingsBtn.setBounds(285, 263, 261, 129);
        getContentPane().add(settingsBtn);
        
       
	}
}
