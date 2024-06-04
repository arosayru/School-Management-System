package controller;
import model.MTeacherDelete;

public class CTeacherDelete {
    private MTeacherDelete model;
    
    public CTeacherDelete(){
        model = new MTeacherDelete();
    }
    
    public void deleteTeacher(int t_id){
        model.deleteTeacher(t_id);
    }
}
