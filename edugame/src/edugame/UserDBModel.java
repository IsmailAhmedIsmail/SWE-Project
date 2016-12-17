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


    public static boolean mailQuery(String mail) throws IOException, ClassNotFoundException {
        

        try(ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));) {
            while (true) {
                User u = (Student) f.readObject();
                if (u.getEmail().equals(mail)) {
                    return true;
                }

            }
        } catch (EOFException ex) {
            return false;
        }
    }

    public static void add(User u) throws FileNotFoundException, IOException {
        ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("Users//users.txt", true));
        f.writeObject(u);
        f.close();
    }
//    void add(String name,String gender,int age, String mail, String username, String password, int ID){
//        User
//    }


    public static boolean UserNameQuery(String username) throws IOException, ClassNotFoundException {
        
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));){
            while (true) {
                User u = (Student) f.readObject();
                if (u.getUsername().equals(username)) {
                    f.close();
                    return true;
                }

            }
        } catch (EOFException ex) {
            return false;
        }
    }


    public static String IdentityQuery(int ID) throws IOException, ClassNotFoundException {
        
        User u = new Student();
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));){
            while (true) {
                u = (Student) f.readObject();
                if (u.getID()==ID) {
                    break;
                }

            }
        } catch (EOFException ex) {
        } finally {
            return u.getIdentity();
        }
    }


    public static void retrieve(User user, int Id) throws IOException, ClassNotFoundException {
        
        User u = new Student();
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));){
            while (true) {
                if (user instanceof Student) {
                    u = (Student) f.readObject();
                } else if (user instanceof Teacher) {
                    u = (Teacher) f.readObject();
                }
                if (u.getID()==Id) {
                    user = u;
                    f.close();
                    break;
                }

            }
        } catch (EOFException ex) {
        }
    }
    public static int UserQuery(String username, String password) throws IOException, ClassNotFoundException
    {
        
        User u = new Student();
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));){
            while (true) {
//                if (user instanceof Student) {
//                    u = (Student) f.readObject();
//                } else if (user instanceof Teacher) {
                    u = (Teacher) f.readObject();
//                }
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    return u.getID();
                }

            }
        } catch (EOFException ex) {
            return -1;
        }
    }
}
