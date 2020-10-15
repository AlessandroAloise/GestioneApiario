
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alessandro.aloise
 */
public class ConnectSql {

    private final static String URL = "jdbc:mysql://localhost:3307/gestione_apiario?";
    private final static String USER = "admin";
    private final static String PASSWORD = "rootroot";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String SELECT = "SELECT * from utenti";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                PreparedStatement pstmt = conn.prepareStatement(SELECT);
        ) {
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
