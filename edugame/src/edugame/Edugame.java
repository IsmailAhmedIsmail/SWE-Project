
package edugame;

import java.io.FileInputStream;
import java.io.IOException;

public class Edugame {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileInputStream f= new FileInputStream("Input.txt");
//        System.setIn(f);
        
        
        WelcomePage r = new WelcomePage();
//        r.Register();
        User u = r.Login();
        GameBuilder gb = new GameBuilder();
        gb.AddGame((Teacher)u);
//        f.close();
    }
    
}
