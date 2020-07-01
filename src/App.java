import java.sql.*;

public class App {
	
	//Link per locale
	//private final String url = "jdbc:postgresql://localhost/postgres?user=postgres&password=postgres";
	
	//Link per Docker container
	//Sostituire l'IPv4 con quello del network
	private final String url = "jdbc:postgresql://172.18.0.2:5432/postgres?user=postgres&password=postgres";
	
	    /**
	     * Connect to the PostgreSQL database
	     *
	     * @return a Connection object
	     * @throws ClassNotFoundException 
	**/
	static Connection conn = null;
	
	    public Connection connect() throws ClassNotFoundException {
	       // Connection conn = null;
		 try {
			 Class.forName("org.postgresql.Driver");
	          conn = DriverManager.getConnection(url);
	            System.out.println("Connected to the PostgreSQL server successfully.");
   } catch (SQLException e) {
	            System.out.println(e.getMessage());
			}
	        return conn;
	    }
	
	    public static void viewTable(Connection con)
	    	    throws SQLException {

	    	    Statement stmt = null;
	    	    String query = "select * from cats;";
	    	    
	    	    try {
	    	        stmt = con.createStatement();
	    	        ResultSet rs = stmt.executeQuery(query);
	    	        while (rs.next()) {
	    	            String name = rs.getString("name");
	    	            int id = rs.getInt("id");
	    	            System.out.println(name + "\t" + id);
	    	        }
	    	    } finally {
	    	        if (stmt != null) { stmt.close(); }
	    	    }
	    	}
	    
	    /**
	     * @param args the command line arguments
	     * @throws ClassNotFoundException 
	     */
	    public static void main(String[] args) throws ClassNotFoundException {
	        App app = new App();
				
	        app.connect();

	        Statement stmt = null;
	        String query = "INSERT INTO cats (id, name) VALUES (1, 'Chiara');";

    	    try {
    	    	
    	    	stmt = conn.createStatement();
    	        stmt.execute(query);
    	        
    	        query = "select * from cats;";
    	        
			stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        while (rs.next()) {
	            String name = rs.getString("name");
	            int id = rs.getInt("id");
	            System.out.println(name + "\t" + id);
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }

	}
