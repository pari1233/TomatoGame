package game;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class LoginGUI extends JFrame {
	private static final long serialVersionUID = -3795117086340444040L;
    private JPasswordField passwordTxt;

    public LoginGUI() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        setLocationRelativeTo(null);

        // Create a JPanel to hold both the video background and the login form components
        JPanel backPanel = new JPanel() {
        	private static final long serialVersionUID = -3795117086340444040L;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Paint the video background
                // You can add code here to paint the video background if it's not added programmatically
            }
        };
        backPanel.setBackground(new Color(0, 0, 0));
        backPanel.setLayout(null);
        getContentPane().add(backPanel);

        // Add video background to the mainPanel
        //Design.setVideo("images/HomeVideo.mp4", backPanel);

        // Add login form components to the mainPanel
        JPanel loginPanel = new JPanel();
        loginPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
        loginPanel.setBackground(new Color(64, 0, 64));
        loginPanel.setOpaque(false); // Make it transparent
        loginPanel.setBounds(214, 96, 390, 297); // Adjusted positioning to ensure visibility
        backPanel.add(loginPanel);
        loginPanel.setLayout(null);

        JTextField usernameTxt = new JTextField();
        usernameTxt.setBounds(155, 87, 179, 24);
        loginPanel.add(usernameTxt);

        JLabel loginLbl = new JLabel("Login");
        loginLbl.setBounds(154, 11, 88, 50);
        loginLbl.setForeground(new Color(255, 255, 255));
        loginLbl.setBackground(new Color(255, 255, 255));
        loginLbl.setFont(new Font("Baskerville Old Face", Font.BOLD, 26));
        loginPanel.add(loginLbl);

        JLabel usernameLbl = new JLabel("User Name : ");
        usernameLbl.setBounds(45, 86, 100, 22);
        usernameLbl.setForeground(new Color(255, 255, 255));
        usernameLbl.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        loginPanel.add(usernameLbl);

        JLabel passwordLbl = new JLabel("Password : ");
        passwordLbl.setBounds(45, 135, 82, 22);
        passwordLbl.setForeground(new Color(255, 255, 255));
        passwordLbl.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        loginPanel.add(passwordLbl);

        JLabel lblNewLabel = new JLabel("To create an account :");
        lblNewLabel.setBounds(58, 240, 141, 14);
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 14));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        loginPanel.add(lblNewLabel);

        JButton registerBtn = new JButton("Register");
        registerBtn.setForeground(new Color(255, 255, 255));
        registerBtn.setBounds(209, 230, 108, 33);
        registerBtn.setBackground(new Color(255, 165, 0));
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Design.playButtonClickSound();
                if(e.getSource()==registerBtn) {
                    setVisible(false);
                    new RegisterGUI().setVisible(true);
                }
            }
        });
        registerBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        loginPanel.add(registerBtn);

        JButton loginBtn = new JButton("Login");
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBounds(124, 179, 134, 33);
        loginBtn.setBackground(new Color(206, 0, 0));
        loginBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        loginPanel.add(loginBtn);

        setLocationRelativeTo(null);
        passwordTxt = new JPasswordField();
        passwordTxt.setBounds(155, 134, 179, 24);
        loginPanel.add(passwordTxt);
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Design.playButtonClickSound();
                String username = usernameTxt.getText();
                String password = new String(passwordTxt.getPassword()); // Retrieve password as char array

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username and password cannot be empty");
                    return; // Exit the method if fields are empty
                }

                String query = "select * from register where userName='" + username + "' AND Password= '" + password + "'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        setVisible(false);
                        new MenuGUI().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Credentials");
                    }
                } catch (Exception ev) {
                    ev.printStackTrace();
                }
            }
        });  
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginGUI().setVisible(true));
    }
}
