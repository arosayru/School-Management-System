package model;
import java.sql.*;

public class dbConnection {
    private static Connection con;
    
    public static Connection getDbConnection(){
        try{
            String dbpath = "jdbc:mysql://localhost/school_management_system";
            con = DriverManager.getConnection(dbpath, "root", "");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return con;
    }
}
