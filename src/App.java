import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	//postgresql://postgres:password@localhost:5432/postgres
	private final String url = "jdbc:postgresql://localhost:5432/pgexample";
	    private final String user = "postgres";
	    private final String password = "password";

	    /**
	     * Connect to the PostgreSQL database
	     *
	     * @return a Connection object
	     
	    public Connection connect() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
			}

	        return conn;
	    }
	    */
	    
	    public void connect() {
	    	
	          try {
	              Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","password");
	              Statement stmt = con.createStatement();
	              ResultSet rs = stmt.executeQuery("SELECT * FROM cats");

	              while (rs.next()) {
	                  int id = rs.getInt("id");
	                  String name = rs.getString("name");
	                  System.out.println(id + "   " + name);

	              }
	          } catch (SQLException e) {
	              System.out.println("SQL exception occured" + e);
	          }
	      }

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        App app = new App();
				
	        app.connect();
	    }

	}
