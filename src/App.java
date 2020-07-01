import java.sql.*;

public class App {
	
	//Link per locale
	//private final String url = "jdbc:postgresql://localhost/postgres?user=postgres&password=postgres";
	
	//Link per Docker container
	private final String url = "jdbc:postgresql://172.19.0.1:5432/postgres?user=postgres&password=postgres";
	
	    /**
	     * Connect to the PostgreSQL database
	     *
	     * @return a Connection object
	     * @throws ClassNotFoundException 
	**/
	     
	    public Connection connect() throws ClassNotFoundException {
	        Connection conn = null;
		 try {
			 Class.forName("org.postgresql.Driver");
	          conn = DriverManager.getConnection(url);
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
