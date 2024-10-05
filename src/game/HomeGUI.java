 package game;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class HomeGUI extends JFrame {

	private static final long serialVersionUID = -3795117086340444040L;

	public HomeGUI() {
		setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);

        // Set the content pane layout to BorderLayout
        getContentPane().setLayout(new BorderLayout());

        // Create an instance of Design and set the video background
        Design.setVideoBackground("Game/images/HomeVideo.mp4", getContentPane(),new LoginGUI());

        // Ensure the frame is centered on the screen
        setLocationRelativeTo(null); 
	}

	public static void main(String[] args) {
		HomeGUI frame = new HomeGUI();
        frame.setVisible(true);
	    
	}

	
}
