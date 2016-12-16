/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author IsmailAhmed
 */
public class UserDBModel {

    public UserDBModel() {
    }

    boolean mailQuery(String mail) throws IOException, ClassNotFoundException {
        ObjectInputStream f = new ObjectInputStream(new FileInputStream("users.txt"));
        try {
            while (true) {
                User u = (Student) f.readObject();
                if (u.getEmail().equals(mail)) {
                    f.close();
                    return false;
                }

            }
        } catch (EOFException ex) {
            f.close();
            return true;
        }
    }

    void add(User u) throws FileNotFoundException, IOException {
        ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("users.txt", true));
        f.writeObject(u);
        f.close();
    }
//    void add(String name,String gender,int age, String mail, String username, String password, int ID){
//        User
//    }

    boolean UserNameQuery(String username) throws IOException, ClassNotFoundException {
        ObjectInputStream f = new ObjectInputStream(new FileInputStream("users.txt"));
        try {
            while (true) {
                User u = (Student) f.readObject();
                if (u.getUsername().equals(username)) {
                    f.close();
                    return false;
                }

            }
        } catch (EOFException ex) {
            f.close();
            return true;
        }
    }

    String IdentityQuery(String ID) throws IOException, ClassNotFoundException {
        ObjectInputStream f = new ObjectInputStream(new FileInputStream("users.txt"));
        User u = new Student();
        try {
            while (true) {
                u = (Student) f.readObject();
                if (u.getID().equals(ID)) {
                    f.close();
                    break;
                }

            }
        } catch (EOFException ex) {
            f.close();
        } finally {
            return u.getIdentity();
        }
    }

    void retrieve(User user, String Id) throws IOException {
        ObjectInputStream f = new ObjectInputStream(new FileInputStream("users.txt"));
        User u = new Student();
        try {
            while (true) {
                if (user instanceof Student) {
                    u = (Student) f.readObject();
                } else if (user instanceof Teacher) {
                    u = (Teacher) f.readObject();
                }
                if (u.getID().equals(ID)) {
                    user = u;
                    f.close();
                    break;
                }

            }
        } catch (EOFException ex) {
            f.close();
        }
    }
    int UserQuery(String username, String password) throws IOException
    {
        ObjectInputStream f = new ObjectInputStream(new FileInputStream("users.txt"));
        User u = new Student();
        try {
            while (true) {
//                if (user instanceof Student) {
//                    u = (Student) f.readObject();
//                } else if (user instanceof Teacher) {
                    u = (Teacher) f.readObject();
//                }
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    f.close();
                    return u.getID();
                }

            }
        } catch (EOFException ex) {
            f.close();
            return -1;
        }
    }
}
