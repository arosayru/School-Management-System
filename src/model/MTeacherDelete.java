package model;
import javax.swing.JOptionPane;
import java.sql.*;

public class MTeacherDelete {
    public void deleteTeacher(int t_id){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "DELETE FROM teacher WHERE t_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, t_id);
            
            int rowCount = pstmt.executeUpdate();
            
            if(rowCount > 0){
                JOptionPane.showMessageDialog(null, "Teacher deleted successfully.");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
