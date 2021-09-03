package datos;
import java.sql.*;
/**
 *
 * @author tonyp
 */
public class Conexion {
    // Database credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pruebajdbc?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";
    
    // connection method with class/conn parameters
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
    
    public static void close(PreparedStatement pstmt) throws SQLException{
        pstmt.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
     
    
    
}
