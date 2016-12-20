package edugame;

import java.io.IOException;
import java.util.Scanner;

public class WelcomePage {

    static String Name, Gender, Email, Username, Password, Identity;
    static int Age;

    public WelcomePage() {
    }

    public static void SetName(String name) {
        Name = name;
    }

    public static void SelectGender(int i) {
        if (i == 1) {
            Gender = "Male";
        } else {
            Gender = "Female";
        }
    }

    public static void SetAge(int age) {
        Age = age;
    }

    public static void SetEmail(String email) {//check if it email or not
        Email = email;
    }

    public static void SetUsername(String username) {
        Username = username;
    }

    public static void SetPassword(String password) {
        Password = password;
    }

    public static void SelectIdentity(int i) {
        if (i == 1) {
            Identity = "Teacher";
        } else {
            Identity = "Student";
        }
    }

    public static void ShowMsg(String msg) {
        System.out.println(msg);
    }

    public static void Register() throws IOException, ClassNotFoundException {
        AuthenticationControl ac = new AuthenticationControl();
        System.out.print("Enter your name: ");
        Scanner input = new Scanner(System.in);
        SetName(input.nextLine());
        System.out.print("Select 1 if Male, 2 if Female: ");
        SelectGender(input.nextInt());
        System.out.print("Enter your Age: ");
        SetAge(input.nextInt());
        input.nextLine();
        System.out.print("Enter your Email: ");
        SetEmail(input.nextLine());
        while (!ac.EmailValidity(Email)) { //new Change
            System.out.println("Enter a Valid Email address, please!");
            SetEmail(input.nextLine());
        }
        while (!ac.CheckAvailability(Email)) {
            System.out.println("Email Already exists.\nRe-enter your email, please!");
            SetEmail(input.nextLine());
        }
        System.out.print("Enter your Username: ");
        SetUsername(input.nextLine());
        while (!ac.CheckUserAvail(Username)) {
            System.out.print("Username Already exists.\nRe-enter your Username, please!");
            SetUsername(input.nextLine());
        }
        System.out.print("Enter your Password: ");
        SetPassword(input.next());
        System.out.print("Select 1 if Teacher, 2 if Student: ");
        SelectIdentity(input.nextInt());
        System.out.print("Press 1 to submit: ");
        input.nextInt();
        ac.CreateUser(Name, Gender, Age, Email, Username, Password, Identity);
        System.out.println("Successfully Signed up.");
    }

    public static User Login() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Username: ");
        SetUsername(input.nextLine());
        System.out.print("Enter your Password: ");
        SetPassword(input.next());
        System.out.print("Press 1 to login: ");
        input.nextInt();
        AuthenticationControl ac = new AuthenticationControl();
        User u = ac.checkExistence(Username, Password);
        while (u == null) {
            input.nextLine();
            ShowMsg("Re-Enter your username and password again, please!");
            System.out.print("Enter your Username: ");
            SetUsername(input.nextLine());
            System.out.print("Enter your Password: ");
            SetPassword(input.next());
            System.out.print("Press 1 to login: ");
            input.nextInt();
            u = ac.checkExistence(Username, Password);
        }
        return u;
    }
}
