package model;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MStudentAdd {
    public void studentDetails(String s_fname,String s_address,Date s_dob,int s_tel,String s_parent_name,String s_class){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "INSERT INTO student (s_fname,s_address,s_dob,s_tel,s_parent_name,s_class) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s_fname);
            pstmt.setString(2, s_address);
            pstmt.setDate(3, s_dob);
            pstmt.setInt(4, s_tel);
            pstmt.setString(5, s_parent_name);
            pstmt.setString(6, s_class);
            
            int raw_count = pstmt.executeUpdate();
            if(raw_count>0){
                JOptionPane.showMessageDialog(null, "Student Added Successfully.");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public DefaultTableModel getStudentTableModel(){
        String[] columnNames = {"Student ID", "Full Name", "Address", "DOB", "Telephone", "Parent's Name", "Class"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Object[] row = {
                    rs.getInt("s_id"),
                    rs.getString("s_fname"),
                    rs.getString("S_address"),
                    rs.getDate("S_dob"),
                    rs.getInt("s_tel"),
                    rs.getString("s_parent_name"),
                    rs.getString("s_class")
                };
                model.addRow(row);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return model;
    }
    
    public DefaultTableModel getStudentTableModel(String selectedClass){
        String[] columnNames = {"Student ID", "Full Name", "Address", "DOB", "Telephone", "Parent's Name", "Class"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        try{
            Connection con = dbConnection.getDbConnection();
            String sql;
            if("All".equals(selectedClass)){
                sql = "SELECT * FROM student";
            }else{
                sql = "SELECT * FROM student WHERE s_class = ?";
            }
            PreparedStatement pstmt = con.prepareStatement(sql);
            if (!"All".equals(selectedClass)) {
                pstmt.setString(1, selectedClass);
            }
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("s_id"),
                    rs.getString("s_fname"),
                    rs.getString("s_address"),
                    rs.getDate("s_dob"),
                    rs.getInt("s_tel"),
                    rs.getString("s_parent_name"),
                    rs.getString("s_class")
                };
                model.addRow(row);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return model;
    }
}
