package model;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MTeacherAdd {
    public void teacherDetails(String t_fname,String t_address,Date t_dob,String t_email,int t_tel,String t_subject,String t_section){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "INSERT INTO teacher (t_fname,t_address,t_dob,t_email,t_tel,t_subject,t_section) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, t_fname);
            pstmt.setString(2, t_address);
            pstmt.setDate(3, t_dob);
            pstmt.setString(4, t_email);
            pstmt.setInt(5, t_tel);
            pstmt.setString(6, t_subject);
            pstmt.setString(7, t_section);
            
            int raw_count = pstmt.executeUpdate();
            if(raw_count > 0){
                JOptionPane.showMessageDialog(null, "Teacher Added Successfully.");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public DefaultTableModel getTeacherTableModel(){
        String[] columnNames = {"Teacher ID", "Full Name", "Address", "DOB", "Email", "Telephone", "Subject", "Section"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "SELECT * FROM teacher";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Object[] row = {
                    rs.getInt("t_id"),
                    rs.getString("t_fname"),
                    rs.getString("t_address"),
                    rs.getDate("t_dob"),
                    rs.getString("t_email"),
                    rs.getInt("t_tel"),
                    rs.getString("t_subject"),
                    rs.getString("t_section")
                };
                model.addRow(row);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return model;
    }
    
    public DefaultTableModel getTeacherTableModel(String selectedClass){
        String[] columnNames = {"Teacher ID", "Full Name", "Address", "DOB", "Email", "Telephone", "Subject", "Section"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        try{
            Connection con = dbConnection.getDbConnection();
            String sql;
            if("All".equals(selectedClass)){
                sql = "SELECT * FROM teacher";
            }else{
                sql = "SELECT * FROM teacher WHERE t_section = ?";
            }
            PreparedStatement pstmt = con.prepareStatement(sql);
            if (!"All".equals(selectedClass)) {
                pstmt.setString(1, selectedClass);
            }
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("t_id"),
                    rs.getString("t_fname"),
                    rs.getString("t_address"),
                    rs.getDate("t_dob"),
                    rs.getString("t_email"),
                    rs.getInt("t_tel"),
                    rs.getString("t_subject"),
                    rs.getString("t_section")
                };
                model.addRow(row);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return model;
    }
}
