package model;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MPrincipalAdd {
    public void principalDetails(String p_fname,String p_address,Date p_dob,String p_email,int p_tel,String p_status){
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "INSERT INTO principal (p_fname,p_address,p_dob,p_email,p_tel,p_status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, p_fname);
            pstmt.setString(2, p_address);
            pstmt.setDate(3, p_dob);
            pstmt.setString(4, p_email);
            pstmt.setInt(5, p_tel);
            pstmt.setString(6, p_status);
            
            int raw_count = pstmt.executeUpdate();
            if(raw_count>0){
                JOptionPane.showMessageDialog(null, "Principal Added Successfully.");
            }
        }catch(SQLException e){
             System.err.println(e.getMessage());
        }
    }
    
    public DefaultTableModel getPrincipalTableModel(){
        String[] columnNames = {"Principal ID", "Full Name", "Address", "DOB", "Email", "Telephone", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        try{
            Connection con = dbConnection.getDbConnection();
            String sql = "SELECT * FROM principal";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Object[] row = {
                    rs.getInt("p_id"),
                    rs.getString("p_fname"),
                    rs.getString("p_address"),
                    rs.getDate("p_dob"),
                    rs.getString("p_email"),
                    rs.getInt("p_tel"),
                    rs.getString("p_status")
                };
                model.addRow(row);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return model;
    }
}
