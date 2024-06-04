package controller;
import model.Msignup;

public class Csignup {
    public void registerUser(String User_fname,String User_address,String User_email,int User_tel,String Username,String Password,String Con_password,String Role){
        Msignup muser = new Msignup();
        muser.registerSchoolUser(User_fname, User_address, User_email, User_tel, Username, Password, Con_password, Role);
    }
}
