package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MTeacherUpdate {
    public void updateTeacher(int t_id,String t_fname,String t_address,Date t_dob,String t_email,int t_tel,String t_subject,String t_section){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "UPDATE teacher SET t_fname = ?, t_address = ?, t_dob = ?, t_email = ?, t_tel = ?, t_subject = ?, t_section = ? WHERE t_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, t_fname);
            pstmt.setString(2, t_address);
            pstmt.setDate(3, new java.sql.Date(t_dob.getTime()));
            pstmt.setString(4, t_email);
            pstmt.setInt(5, t_tel);
            pstmt.setString(6, t_subject);
            pstmt.setString(7, t_section);
            pstmt.setInt(8, t_id);
            
            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Teacher details updated successfully.");
            }
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public DefaultTableModel getAllTeachers(){
        String[] columnNames = {"Teacher ID", "Full Name", "Address", "DOB", "Email", "Telephone", "Subject", "Section"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "SELECT * FROM teacher";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("t_id");
                String name = rs.getString("t_fname");
                String address = rs.getString("t_address");
                Date dob = rs.getDate("p_dob");
                String email = rs.getString("t_email");
                int tel = rs.getInt("t_tel");
                String subject = rs.getString("t_subject");
                String section = rs.getString("t_sectiom");

                Object[] row = {id, name, address, dob, email, tel, subject, section};
                tableModel.addRow(row);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return tableModel;
    }
}
