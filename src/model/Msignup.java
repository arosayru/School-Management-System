package model;
import java.sql.*;
import javax.swing.JOptionPane;

public class Msignup {
    public void registerSchoolUser(String user_fname,String user_address,String user_email,int user_tel,String username,String password,String con_password,String role){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "INSERT INTO users (user_fname, user_address, user_email, user_tel, username, password, con_password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_fname);
            pstmt.setString(2, user_address);
            pstmt.setString(3, user_email);
            pstmt.setInt(4, user_tel);
            pstmt.setString(5, username);
            pstmt.setString(6, password);
            pstmt.setString(7, con_password);
            pstmt.setString(8, role);
            
            int raw_count = pstmt.executeUpdate();
            if(raw_count>0){
                JOptionPane.showMessageDialog(null, "User Registered Successfully.");
            }
        }catch(SQLException e){
             System.err.println(e.getMessage());
        }
    }
}
