
package edugame;

import java.io.IOException;

public class Edugame {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WelcomePage r = new WelcomePage();
//        r.Register();
        User u = r.Login();
    }
    
}
