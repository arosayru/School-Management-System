package controller;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.MTeacherAdd;

public class CTeacherAdd {
    private MTeacherAdd mta;
    
    public CTeacherAdd(){
        mta = new MTeacherAdd();
    }
    
    public void addTeacher(String T_fname,String T_address,Date T_DOB,String T_email,int T_tel,String T_subject,String T_section){
        java.sql.Date sqlDob = new java.sql.Date(T_DOB.getTime());
        
        MTeacherAdd mta = new MTeacherAdd();
        mta.teacherDetails(T_fname, T_address, sqlDob, T_email, T_tel, T_subject, T_section);
    }
    
    public DefaultTableModel getTeacherTableModel(){
        return mta.getTeacherTableModel();
    }
    
    public DefaultTableModel getTeacherTableModel(String selectedClass) {
        return mta.getTeacherTableModel(selectedClass);
    }
}
