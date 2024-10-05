package game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsGUI extends JFrame {
    private JPanel contentPane;
    private JToggleButton soundOnOffBtn;
    private static final long serialVersionUID = -3795117086340444040L;
    
    public SettingsGUI() {
    	
        setTitle("Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Settings");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setIcon(new ImageIcon("Game/images/settingsicaon.png"));
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 50));
        lblNewLabel.setBounds(286, 103, 363, 67);
        contentPane.add(lblNewLabel);

        JButton backBtn = new JButton("");
        backBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 12));
        backBtn.setBackground(new Color(255, 255, 255));
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Design.playButtonClickSound();
                setVisible(false);
                MenuGUI menu = new MenuGUI();
                menu.setVisible(true);
            }
        });
        backBtn.setIcon(new ImageIcon("Game/images/Sback.png"));
        backBtn.setBounds(30, 11, 63, 67);
        contentPane.add(backBtn);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(178, 34, 34));
        panel.setBounds(163, 156, 504, 199);
        contentPane.add(panel);
                panel.setLayout(null);
        
                JLabel lblNewLabel_1 = new JLabel("Clicking Sounds : ");
                lblNewLabel_1.setBackground(Color.WHITE);
                lblNewLabel_1.setBounds(54, 80, 239, 27);
                panel.add(lblNewLabel_1);
                lblNewLabel_1.setForeground(Color.WHITE);
                lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
                
                        soundOnOffBtn = new JToggleButton("Sound On");
                        soundOnOffBtn.setBounds(310, 75, 138, 40);
                        panel.add(soundOnOffBtn);
                        soundOnOffBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
                        soundOnOffBtn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                boolean soundOn = soundOnOffBtn.isSelected();
                                Design.setSoundOn(soundOn); // Update sound state in Design class
                                if (soundOn) {
                                    soundOnOffBtn.setText("Sound On");
                                } else {
                                    soundOnOffBtn.setText("Sound Off");
                                }
                            }
                        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SettingsGUI settingsGUI = new SettingsGUI();
            settingsGUI.setVisible(true);
        });
    }
}
