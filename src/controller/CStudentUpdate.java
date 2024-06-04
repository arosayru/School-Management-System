package controller;
import model.MStudentUpdate;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class CStudentUpdate {
    private MStudentUpdate model;
    
    public CStudentUpdate(){
        model = new MStudentUpdate();
    }
    
    public DefaultTableModel getStudentTableModel() {
        return model.getAllStudents();
    }
    
    public void updateStudent(int s_id,String s_fname,String s_address,Date s_dob,int s_tel,String s_parent_name,String s_class){
        java.sql.Date sqlDate = new java.sql.Date(s_dob.getTime());
        model.updateStudent(s_id, s_fname, s_address, sqlDate, s_tel, s_parent_name, s_class);
    }
}
