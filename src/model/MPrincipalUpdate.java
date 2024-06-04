package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MPrincipalUpdate {
    public void updatePrincipal(int p_id, String p_fname, String p_address, Date p_dob, String p_email, int p_tel, String p_status){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "UPDATE principal SET p_fname = ?, p_address = ?, p_dob = ?, p_email = ?, p_tel = ?, p_status = ? WHERE p_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, p_fname);
            pstmt.setString(2, p_address);
            pstmt.setDate(3, new java.sql.Date(p_dob.getTime()));
            pstmt.setString(4, p_email);
            pstmt.setInt(5, p_tel);
            pstmt.setString(6, p_status);
            pstmt.setInt(7, p_id);
            
            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Principal details updated successfully.");
            }
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public DefaultTableModel getAllPrincipals(){
        String[] columnNames = {"Principal ID", "Full Name", "Address", "DOB", "Email", "Telephone", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "SELECT * FROM principal";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_fname");
                String address = rs.getString("p_address");
                Date dob = rs.getDate("p_dob");
                String email = rs.getString("p_email");
                int tel = rs.getInt("p_tel");
                String status = rs.getString("p_status");

                Object[] row = {id, name, address, dob, email, tel, status};
                tableModel.addRow(row);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return tableModel;
    }
}
