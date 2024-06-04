package controller;
import model.MTeacherUpdate;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class CTeacherUpdate {
    private MTeacherUpdate model;
    
    public CTeacherUpdate(){
        model = new MTeacherUpdate();
    }
    
    public DefaultTableModel getTeacherTableModel(){
        return model.getAllTeachers();
    }
    
    public void updateTeacher(int t_id, String t_fname, String t_address, Date t_dob, String t_email, int t_tel, String t_subject, String t_section){
        java.sql.Date sqlDate = new java.sql.Date(t_dob.getTime());
        model.updateTeacher(t_id, t_fname, t_address, sqlDate, t_email, t_tel, t_subject, t_section);
    }
}
