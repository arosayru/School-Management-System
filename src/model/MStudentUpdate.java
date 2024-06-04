package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MStudentUpdate {
    public void updateStudent(int s_id,String s_fname,String s_address,Date s_dob,int s_tel,String s_parent_name,String s_class){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "UPDATE student SET s_fname = ?, s_address = ?, s_dob = ?, s_tel = ?,s_parent_name = ?, s_class = ? WHERE s_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s_fname);
            pstmt.setString(2, s_address);
            pstmt.setDate(3, new java.sql.Date(s_dob.getTime()));
            pstmt.setInt(4, s_tel);
            pstmt.setString(5, s_parent_name);
            pstmt.setString(6, s_class);
            pstmt.setInt(7, s_id);
            
            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Student details updated successfully.");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public DefaultTableModel getAllStudents(){
        String[] columnNames = {"Student ID", "Full Name", "Address", "DOB", "Telephone","Parent's Name", "Class"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("s_id");
                String name = rs.getString("s_fname");
                String address = rs.getString("s_address");
                Date dob = rs.getDate("s_dob");
                int tel = rs.getInt("p_tel");
                String spname = rs.getString("s_parent_name");
                String sclass = rs.getString("s_class");
                
                Object[] row = {id, name, address, dob, tel, spname, sclass};
                tableModel.addRow(row);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return tableModel;
    }
}
