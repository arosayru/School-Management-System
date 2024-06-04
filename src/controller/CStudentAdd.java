package controller;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.MStudentAdd;

public class CStudentAdd {
    private MStudentAdd msa;
    
    public CStudentAdd(){
        msa = new MStudentAdd();
    }
    
    public void addStudent(String S_fname,String S_address,Date S_DOB,int S_tel,String S_parent_name,String S_class){
        java.sql.Date sqlDob = new java.sql.Date(S_DOB.getTime());
        
        MStudentAdd msa = new MStudentAdd();
        msa.studentDetails(S_fname, S_address, sqlDob, S_tel, S_parent_name, S_class);
    }
    
    public DefaultTableModel getStudentTableModel(){
        return msa.getStudentTableModel();
    }
    
    public DefaultTableModel getStudentTableModel(String selectedClass) {
        return msa.getStudentTableModel(selectedClass);
    }
}
