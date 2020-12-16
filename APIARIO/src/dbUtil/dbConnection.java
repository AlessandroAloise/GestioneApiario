package dbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * Classe per collegrsi la db.
 *
 * @author Alesssandro Aloise
 * @version 16.12.2020
 */
public class dbConnection {
    
    private static final String USERNAME= "dbuser";
    private static final String PASSWORD= "dbpassword";
    private static final String SQCONN= "jdbc:sqlite:Apiario.sqlite";
    
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);
        }catch (ClassNotFoundException ex ){
            ex.printStackTrace();
        }
        return null;
    }
}
