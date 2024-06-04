package model;
import javax.swing.JOptionPane;
import java.sql.*;

public class MPrincipalDelete {
    public void deletePrincipal(int p_id){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "DELETE FROM principal WHERE p_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, p_id);
            
            int rowCount = pstmt.executeUpdate();
            
            if(rowCount > 0){
                JOptionPane.showMessageDialog(null, "Principal deleted successfully.");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
