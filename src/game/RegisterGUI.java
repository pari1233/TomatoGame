package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = -3795117086340444040L;

    public RegisterGUI() {
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        setLocationRelativeTo(null);

        // Create a JPanel to hold both the video background and the login form components
        JPanel mainPanel = new JPanel() {
        	private static final long serialVersionUID = -3795117086340444040L;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Paint the video background
                // You can add code here to paint the video background if it's not added programmatically
            }
        };
        mainPanel.setBackground(new Color(0, 0, 0));
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);

        // Add video background to the mainPanel
        //Design.setVideo("images/bgv.mp4", mainPanel);

        // Add login form components to the mainPanel
        JPanel loginPanel = new JPanel();
        loginPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        loginPanel.setLayout(null); // Using null layout for absolute positioning
        loginPanel.setOpaque(false); // Make it transparent
        loginPanel.setBounds(187, 92, 398, 329);
        mainPanel.add(loginPanel);

        JTextField usernameTxt = new JTextField();
        usernameTxt.setBounds(185, 75, 179, 24);
        loginPanel.add(usernameTxt);

        JPasswordField passwordTxt = new JPasswordField();
        passwordTxt.setBounds(185, 147, 179, 24);
        loginPanel.add(passwordTxt);

        JLabel registerLbl = new JLabel("SignUp");
        registerLbl.setForeground(new Color(255, 255, 255));
        registerLbl.setFont(new Font("Baskerville Old Face", Font.BOLD, 26));
        registerLbl.setBounds(147, 11, 145, 50);
        loginPanel.add(registerLbl);

        JLabel usernameLbl = new JLabel("User Name : ");
        usernameLbl.setForeground(new Color(255, 255, 255));
        usernameLbl.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        usernameLbl.setBounds(37, 74, 100, 22);
        loginPanel.add(usernameLbl);

        JLabel passwordLbl = new JLabel("Password : ");
        passwordLbl.setForeground(new Color(255, 255, 255));
        passwordLbl.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        passwordLbl.setBounds(37, 146, 82, 22);
        loginPanel.add(passwordLbl);
        
        JLabel emailLbl = new JLabel("Email : ");
        emailLbl.setForeground(new Color(255, 255, 255));
        emailLbl.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        emailLbl.setBounds(37, 113, 82, 22);
        loginPanel.add(emailLbl);

        JTextField emailTxt = new JTextField();
        emailTxt.setBounds(185, 110, 179, 24);
        loginPanel.add(emailTxt);

        JLabel cpasswordLbl = new JLabel("Confirm Password : ");
        cpasswordLbl.setForeground(new Color(255, 255, 255));
        cpasswordLbl.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
        cpasswordLbl.setBounds(37, 182, 145, 22);
        loginPanel.add(cpasswordLbl);

        JPasswordField cpasswordTxt = new JPasswordField();
        cpasswordTxt.setBounds(185, 181, 179, 24);
        loginPanel.add(cpasswordTxt);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBackground(new Color(223, 0, 0));
        registerBtn.setForeground(new Color(255, 255, 255));
        registerBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        registerBtn.setBounds(120, 238, 134, 33);
        loginPanel.add(registerBtn);
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Design.playButtonClickSound();
                String userName = usernameTxt.getText();
                String email = emailTxt.getText();
                String password = new String(passwordTxt.getPassword());
                String confirmPassword = new String(cpasswordTxt.getPassword());

                if (userName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required");
                    return;
                }
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                if (!email.matches(emailRegex)) {
                    JOptionPane.showMessageDialog(null, "Invalid email format");
                    return;
                }              
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match");
                    return;
                }
                if (!isStrongPassword(password)) {
                    JOptionPane.showMessageDialog(null, "Password is not strong enough. Password must contain at least 8 characters including uppercase, lowercase letters, numbers, and special characters.");
                    return;
                }

                String query = "insert into register values('" + userName + "','" + email + "','" + password + "','" + confirmPassword + "')";
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Registered Successfully.");
                    setVisible(false);
                    new LoginGUI().setVisible(true);
                } catch (Exception ev) {
                    ev.printStackTrace();
                }
            }
        });}
        private boolean isStrongPassword(String password) {
            // Define criteria for a strong password
            int minLength = 8;
            boolean hasUppercase = false;
            boolean hasLowercase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;
            String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

            // Check each character in the password
            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLowercase = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                } else if (specialChars.contains(String.valueOf(ch))) {
                    hasSpecialChar = true;
                }
            }
            return password.length() >= minLength && hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisterGUI().setVisible(true));
    }
}
