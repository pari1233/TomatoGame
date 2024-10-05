package game;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/game1", "root", "P@r!123#");
            s = c.createStatement();
            System.out.println("Database connected successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }

    public static void main(String[] args) {

    }

	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}