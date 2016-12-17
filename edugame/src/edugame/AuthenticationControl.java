/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edugame;

import java.io.IOException;

/**
 *
 * @author IsmailAhmed
 */
public class AuthenticationControl {

    public AuthenticationControl() {
    }
    
    public static void checkExistence(String username, String password) throws IOException, ClassNotFoundException{
        int ID = UserDBModel.UserQuery(username, password);
        User u;
        Homepage h;
        if(ID!=-1){
            if(UserDBModel.IdentityQuery(ID)=="Student"){
                u = new Student();
                h = new Homepage();
            }
            else{
                u = new Teacher();
                h = new TeacherHomePage();
            }
            UserDBModel.retrieve(u, ID);
        }
        WelcomePage.ShowMsg("Re-Enter your username ans password again, please!");
    }
    
}
