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

    public static boolean CheckAvailability(String Mail) throws IOException, ClassNotFoundException {
//        UserDBModel u = null;
        if (UserDBModel.mailQuery(Mail)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean CheckUserAvail(String UserName) throws IOException, ClassNotFoundException {
//        UserDBModel u = null;
        if (UserDBModel.UserNameQuery(UserName)) {
            return false;
        } else {
            return true;
        }
    }

    public static User checkExistence(String username, String password) throws IOException, ClassNotFoundException {
        int ID = UserDBModel.UserQuery(username, password);
        User u;
        Homepage h;
        if (ID != -1) {
            if (UserDBModel.IdentityQuery(ID).equals("Student") ) {
                u = new Student();
                h = new Homepage();
            } else {
                u = new Teacher();
                h = new TeacherHomePage();
            }
            UserDBModel.retrieve(u, ID);
            return u;
        }
        else{
            return null;
        }
    }

    public static void CreateUser(String Name, String Gender, int age, String email, String UserName, String Password, String Identity) throws IOException {
        if (Identity.equals("Teacher")) {
            Teacher te = new Teacher(Name, Gender, age, email, UserName, Password);
            UserDBModel.add(te);

        } else {
            Student st = new Student(Name, Gender, age, email, UserName, Password);
            UserDBModel.add(st);
        }
    }
}
