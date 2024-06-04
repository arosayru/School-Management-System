package controller;
import model.MStudentDelete;

public class CStudentDelete {
    private MStudentDelete model;
    
    public CStudentDelete(){
        model = new MStudentDelete();
    }
    
    public void deleteStudent(int s_id){
        model.deleteStudent(s_id);
    }
}
