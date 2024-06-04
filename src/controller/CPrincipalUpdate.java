package controller;
import model.MPrincipalUpdate;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class CPrincipalUpdate {
    private MPrincipalUpdate model;
    
    public CPrincipalUpdate(){
        model = new MPrincipalUpdate();
    }
    
    public DefaultTableModel getPrincipalTableModel() {
        return model.getAllPrincipals();
    }
    
    public void updatePrincipal(int p_id, String p_fname, String p_address, Date p_dob, String p_email, int p_tel, String p_status) {
        java.sql.Date sqlDate = new java.sql.Date(p_dob.getTime());
        model.updatePrincipal(p_id, p_fname, p_address, sqlDate, p_email, p_tel, p_status);
    }
}
