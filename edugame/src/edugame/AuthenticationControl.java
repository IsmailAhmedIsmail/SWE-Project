/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;
import static edugame.Edugame.input;
import java.io.IOException;

/**
 *
 * @author IsmailAhmed
 */
public class AuthenticationControl {

    public AuthenticationControl() {
    }

    public boolean EmailValidity(String email) { //new function
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
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

    public void Login() throws IOException, ClassNotFoundException {
        input.nextLine();
        String Username = WelcomePage.SetUsername();
        String Password = WelcomePage.SetPassword();
        User u = checkExistence(Username, Password);
        while (u == null) {
            WelcomePage.ShowMsg("Invalid Username or Password, Reenter Values");
            Username = WelcomePage.SetUsername();
            Password = WelcomePage.SetPassword();
            u = checkExistence(Username, Password);
        }
        if(u instanceof Student)
        {
            Homepage hp= new Homepage(u);
        }
        else
        {
            Homepage hp= new TeacherHomePage((Teacher)u);
        }
        
    }
    public void Register() throws IOException, ClassNotFoundException{
        
        input.nextLine();
        String Name= WelcomePage.SetName();
        
        String Gender= WelcomePage.SelectGender();
        
        int Age= WelcomePage.SetAge();
        input.nextLine();
        String Email= WelcomePage.SetEmail();
        String Username=WelcomePage.SetUsername();
        while (!CheckUserAvail(Username)) {
            WelcomePage.ShowMsg("Username Already exists.\nRe-enter your Username, please!");
            Username=WelcomePage.SetUsername();
        }
        String Password=WelcomePage.SetPassword();
        String Identity=WelcomePage.SelectIdentity();
        input.nextLine();
        CreateUser(Name, Gender, Age, Email, Username, Password, Identity);
        WelcomePage.ShowMsg("Successfully Signed up.");
    }
    public static User checkExistence(String username, String password) throws IOException, ClassNotFoundException {
        int ID = UserDBModel.UserQuery(username, password);
        User u;
        
        if (ID != -1) {
            if (UserDBModel.IdentityQuery(ID).equals("Student")) {
                u = new Student();
               
            } else {
                u = new Teacher();
               
            }
            u = UserDBModel.retrieve(u, ID);
            return u;
        } else {
            return null;
        }
    }

    public static void CreateUser(String Name, String Gender, int age, String email, String UserName, String Password, String Identity) throws IOException {
        User u;
        if (Identity.equals("Teacher")) {
            u = new Teacher(Name, Gender, age, email, UserName, Password);

        } else {
            u = new Student(Name, Gender, age, email, UserName, Password);
        }
        UserDBModel.add(u);
    }
}
