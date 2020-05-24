import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	private final String url = "jdbc:postgresql://172.18.0.1:5432/pgexample";
	    private final String user = "admin";
	    private final String password = "password";

	    /**
	     * Connect to the PostgreSQL database
	     *
	     * @return a Connection object
	     * @throws ClassNotFoundException 
	**/
	     
	    public Connection connect() throws ClassNotFoundException {
	        Connection conn = null;
		 try {
			 Class.forName("com.example.jdbc.Driver");
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");
   } catch (SQLException e) {
	            System.out.println(e.getMessage());
			}
	        return conn;
	    }
	

	    /**
	     * @param args the command line arguments
	     * @throws ClassNotFoundException 
	     */
	    public static void main(String[] args) throws ClassNotFoundException {
	        App app = new App();
				
	        app.connect();
	    }

	}
