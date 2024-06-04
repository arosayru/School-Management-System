package controller;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.MPrincipalAdd;

public class CPrincipalAdd {
    private MPrincipalAdd mpa;
    
    public CPrincipalAdd(){
        mpa = new MPrincipalAdd();
    }
    public void addPrincipal(String P_fname,String P_address,Date P_DOB,String P_email,int P_tel,String P_status){
        java.sql.Date sqlDob = new java.sql.Date(P_DOB.getTime());
        
        MPrincipalAdd mpa = new MPrincipalAdd();
        mpa.principalDetails(P_fname,P_address,sqlDob,P_email,P_tel,P_status);
    }
    
    public DefaultTableModel getPrincipalTableModel() {
        return mpa.getPrincipalTableModel();
    }
}
