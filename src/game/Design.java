package game;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.File;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Container;



import javax.swing.SwingUtilities;
public class Design {
	private static boolean soundOn = true;
    public static void setVideoBackground(String videoPath, Container container, JFrame nextPage) {
        // Creating JavaFX components on Swing thread
        SwingUtilities.invokeLater(() -> {
            // Create a JFXPanel for JavaFX components
            JFXPanel jfxPanel = new JFXPanel();
            // Create a media player
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(videoPath).toURI().toString()));
            // Auto play the video
            mediaPlayer.setAutoPlay(true);
            // Create a media view to display the video
            MediaView mediaView = new MediaView(mediaPlayer);
            // Create a group to hold the media view
            Group root = new Group();
            root.getChildren().add(mediaView);
            // Create a scene with the group as root
            Scene scene = new Scene(root);
            // Set the size of the scene
            jfxPanel.setScene(scene);
            
            // Access the scene's width and height properties
            scene.widthProperty().addListener((observable, oldValue, newValue) -> {
                mediaView.setFitWidth((double) newValue);
            });
            scene.heightProperty().addListener((observable, oldValue, newValue) -> {
                mediaView.setFitHeight((double) newValue);
            });
            
            // Add the JFXPanel to the provided container
            container.add(jfxPanel, BorderLayout.CENTER);
            
            // Call method to handle end of video
            handleVideoEnd(mediaPlayer, container, nextPage);
        });
    }

    public static void handleVideoEnd(MediaPlayer mediaPlayer, Container container, JFrame nextPage) {
        mediaPlayer.setOnEndOfMedia(() -> {
            // Navigate to the next page
            navigateToPage(container, nextPage);
        });
    }

    public static void navigateToPage(Container container, JFrame nextPage) {
        // Close the current frame
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(container);
        currentFrame.dispose();

        // Show the next page
        nextPage.setVisible(true);
    }
    public static void setVideo(String videoPath, Container container) {
        // Initializing JavaFX environment
        SwingUtilities.invokeLater(() -> {
            new JFXPanel(); // Initializes the JavaFX toolkit
            // Create a JFXPanel for JavaFX components
            JFXPanel jfxBPanel = new JFXPanel();
            // Create a media player
            MediaPlayer mPlayer = new MediaPlayer(new Media(new File(videoPath).toURI().toString()));
            // Auto play the video
            mPlayer.setAutoPlay(true);
            // Loop the video
            mPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            // Create a media view to display the video
            MediaView mediaView = new MediaView(mPlayer);
            // Create a group to hold the media view
            Group root = new Group();
            root.getChildren().add(mediaView);
            // Create a scene with the group as root
            Scene scene = new Scene(root);
            // Set the size of the scene
            jfxBPanel.setScene(scene);
            
            // Access the scene's width and height properties
            scene.widthProperty().addListener((observable, oldValue, newValue) -> {
                mediaView.setFitWidth((double) newValue);
            });
            scene.heightProperty().addListener((observable, oldValue, newValue) -> {
                mediaView.setFitHeight((double) newValue);
            });
            
            // Add the JFXPanel to the provided container
            container.add(jfxBPanel, BorderLayout.CENTER);
        });
    }
    public static void setBackgroundImage(JFrame frame, String imagePath) {
        JPanel backgroundPanel = new JPanel() {
        	private static final long serialVersionUID = -3795117086340444040L;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon(imagePath).getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        frame.setContentPane(backgroundPanel);
        frame.pack();
    }
    public static void playButtonClickSound() {
        if (soundOn) { // Check if sound is enabled
            try {
                // Load the sound file
                File soundFile = new File("Game/Sounds/mouseClick.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);

                // Add a listener to handle the sound playback completion
                clip.addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            event.getLine().close(); // Close the line after the sound finishes playing
                        }
                    }
                });

                // Play the sound
                clip.start();
            } catch (Exception e) {
                // Handle any exceptions
                e.printStackTrace();
            }
        }
    }

    // Method to toggle sound on and off
    public static void toggleSound() {
        soundOn = !soundOn; // Toggle sound state
    }

    // Method to check if sound is enabled
    public static boolean isSoundOn() {
        return soundOn;
    }
    public static void setSoundOn(boolean soundState) {
        soundOn = soundState;
    }
}