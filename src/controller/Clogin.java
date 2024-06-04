package controller;
import model.Mlogin;

public class Clogin {
    private Mlogin ml;
    
    public Clogin(Mlogin ml){
        this.ml=ml;
    }
    
    public boolean login(String Username,String Password){
        return ml.validateUser(Username, Password);
    }
}
