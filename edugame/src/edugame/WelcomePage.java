package edugame;

import static edugame.Edugame.input;
import java.io.IOException;
import java.util.Scanner;

public class WelcomePage {
    
    public WelcomePage() throws IOException, ClassNotFoundException {
        welcome();
    }

    public static String SetName() {
        System.out.print("Enter your name: ");
        return input.nextLine();
    }

    public static String SelectGender() {
        System.out.print("Select 1 if Male, 2 if Female: ");
        int i;
        i = input.nextInt();
        while(i<1 || i>2)
        {
            System.out.println("Invalid Input. Please Enter a valid input:");
            i = input.nextInt();
        }
        if (i == 1) {
            return  "Male";
        } else {
            return "Female";
        }
    }

    public static int SetAge() {
        System.out.print("Enter your Age: ");
        return input.nextInt();
        
    }

    public static String SetEmail() {//check if it email or not
        System.out.print("Enter your Email: ");
        return input.nextLine();
        
    }

    public static String SetUsername() {
        System.out.print("Enter your Username: ");
        return(input.nextLine());
    }

    public static String SetPassword() {
        System.out.print("Enter your Password: ");
        return(input.nextLine());
    }

    public static String SelectIdentity() {
        System.out.print("Select 1 if Teacher, 2 if Student: ");
        int i=input.nextInt();
        while(i<1 || i>2)
        {
            System.out.println("Invalid Input. Please Enter a valid input:");
            i = input.nextInt();
        }
        if (i == 1) {
            return "Teacher";
        } else {
            return "Student";
        }
    }

    public static void ShowMsg(String msg) {
        System.out.println(msg);
    }
    public static void welcome() throws IOException, ClassNotFoundException{
        System.out.println("Welcome!\nChoose an operation:\n1-Register.\n2-Login\n0-Exit.");
        int choice= input.nextInt();
        while(choice<0 || choice>2)
        {
            System.out.println("Invalid Input, Enter a valid value: ");
            choice= input.nextInt();
        }
        switch(choice)
        {
            case(0):
            {
                System.exit(0);
                break;
            }
            case(1):
            {
                AuthenticationControl ac = new AuthenticationControl();
                ac.Register();
                break;
            }
            case(2):
            {
                AuthenticationControl ac = new AuthenticationControl();
                ac.Login();
                
                break;
            }
                    
        }
    }
//    public static void Register() throws IOException, ClassNotFoundException {
//        AuthenticationControl ac = new AuthenticationControl();
//        
//        while (!ac.EmailValidity(Email)) { //new Change
//            System.out.println("Enter a Valid Email address, please!");
//            SetEmail(input.nextLine());
//        }
//        while (!ac.CheckAvailability(Email)) {
//            System.out.println("Email Already exists.\nRe-enter your email, please!");
//            SetEmail(input.nextLine());
//        }
//        System.out.print("Enter your Username: ");
//        SetUsername(input.nextLine());
//        while (!ac.CheckUserAvail(Username)) {
//            System.out.print("Username Already exists.\nRe-enter your Username, please!");
//            SetUsername(input.nextLine());
//        }
//        System.out.print("Enter your Password: ");
//        SetPassword(input.next());
//        System.out.print("Select 1 if Teacher, 2 if Student: ");
//        SelectIdentity(input.nextInt());
//        System.out.print("Press 1 to submit: ");
//        input.nextInt();
//        ac.CreateUser(Name, Gender, Age, Email, Username, Password, Identity);
//        System.out.println();
//    }
    
}
