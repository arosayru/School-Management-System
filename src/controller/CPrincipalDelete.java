package controller;
import model.MPrincipalDelete;

public class CPrincipalDelete {
    private MPrincipalDelete model;
    
    public CPrincipalDelete(){
        model = new MPrincipalDelete();
    }
    
    public void deletePrincipal(int p_id) {
        model.deletePrincipal(p_id);
    }
}
