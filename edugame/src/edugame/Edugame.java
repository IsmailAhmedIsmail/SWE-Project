
package edugame;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Edugame {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileInputStream f= new FileInputStream("Input.txt");
//        System.setIn(f);
        WelcomePage wp = new WelcomePage();
     /*   Homepage hp = new Homepage();
        TeacherHomePage thp = new TeacherHomePage();
        GamePage gp= new GamePage();
        GameBuilder gb = new GameBuilder();
        switch(wp.welcome()){
            case 1:
            {
                
                break;
            }
            case 2:
            {
                User u;
                if(u.getIdentity().equals("Student")){
                    hp.forStud();
                    gp.PlayGame(u);
                }
                else{
                    switch(thp.forTeach()){
                        case 1:
                        {
                            gp.PlayGame(u);
                            break;
                        }
                        case 2:
                        {
                            gb.AddGame((Teacher)u);
                            break;
                        }
                    }
                }
                break;
            }
        }
        */
//        f.close();
    }

    
}
