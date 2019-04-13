import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class StoredProcedure2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String dbURL = "jdbc:mysql://localhost:3306/test";
	        String user = "root";
	        String password = "root";
	        try (
	                Connection conn = DriverManager.getConnection(dbURL, user, password);
	     
	                Statement statement = conn.createStatement();
	            ) {
	     
	            CallableStatement cstmt = conn.prepareCall("{call get_student_by_id(?,?)}");

	            cstmt.setInt(1,123);
	            cstmt.registerOutParameter(2, Types.VARCHAR);

	                // drops the existing procedure if exists
	            	cstmt.execute();
	            	
	                // then creates a new stored procedure
	                String name = cstmt.getString(2);
	     
	                System.out.println(name);
	                statement.close();
	     
	                System.out.println("Stored procedure created successfully!");
	     
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	}

