import java.sql.*;

public class StoredProcedureExample {

	public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/customer";
        String user = "root";
        String password = "root";
 
        try (
            Connection conn = DriverManager.getConnection(dbURL, user, password);
 
            Statement statement = conn.createStatement();
        ) {
 
            String queryDrop = "DROP PROCEDURE IF EXISTS delete_book";
 
            String queryCreate = "CREATE PROCEDURE delete_book (IN bookID INT) ";
            queryCreate += "BEGIN ";
            queryCreate += "DELETE FROM book WHERE book_id = bookID; ";
            queryCreate += "END";
 
            // drops the existing procedure if exists
            statement.execute(queryDrop);
 
            // then creates a new stored procedure
            statement.execute(queryCreate);
 
            statement.close();
 
            System.out.println("Stored procedure created successfully!");
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
