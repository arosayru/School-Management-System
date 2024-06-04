package model;
import javax.swing.JOptionPane;
import java.sql.*;

public class MStudentDelete {
    public void deleteStudent(int s_id){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "DELETE FROM student WHERE s_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, s_id);
            
            int rowCount = pstmt.executeUpdate();
            
            if(rowCount > 0){
                JOptionPane.showMessageDialog(null, "Student deleted successfully.");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
