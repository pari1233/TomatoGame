package game;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Scoreboard  extends JFrame {

	private static final long serialVersionUID = -3795117086340444040L;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblNewLabel;
    private JButton playBtn;

    /**
     * Create the frame.
     */
    public Scoreboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setSize(850, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        JScrollPane scrollPane = new JScrollPane();
        
        lblNewLabel = new JLabel("Score Board");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 32));
        
        playBtn = new JButton("Play Again");
        playBtn.setForeground(Color.WHITE);
        playBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
    	        new LevelsGUI().setVisible(true);
        	}
        });
        playBtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        playBtn.setBackground(new Color(255, 0, 0));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
        					.addGap(304))))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(346)
        			.addComponent(playBtn, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(296, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        			.addGap(27)
        			.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
        			.addGap(38)
        			.addComponent(playBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(52))
        );

        table = new JTable();
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);

        // Populate the table
        displayScores();
    }

    private void displayScores() {
        try {
            // Establishing connection to the database
            Conn conn = new Conn();
            Connection c = conn.c;
            Statement s = conn.s;

            // Execute a query
            String sql = "SELECT * FROM scoreboard";
            ResultSet rs = s.executeQuery(sql);

            // Create table model with column names
            DefaultTableModel model = new DefaultTableModel(new String[]{"User ID", "Username", "Low Score", "Medium Score", "High Score"}, 0);

            // Add rows to the table model
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String userName = rs.getString("UserName");
                int lowScore = rs.getInt("lowscore");
                int mediumScore = rs.getInt("mediumscore");
                int highScore = rs.getInt("highscore");
                model.addRow(new Object[]{userId, userName, lowScore, mediumScore, highScore});
            }

            // Set the table model to the JTable
            table.setModel(model);

            // Clean-up environment
            rs.close();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to retrieve data from the database.");
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scoreboard ().setVisible(true);
            }
        });
    }
}


