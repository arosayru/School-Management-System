package model;
import java.sql.*;
import javax.swing.JOptionPane;

public class Mlogin {
    public boolean validateUser(String username, String password){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rst = pstmt.executeQuery();
            return rst.next();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
}
