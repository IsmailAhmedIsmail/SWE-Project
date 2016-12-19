/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

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
                User u = (User) f.readObject();
                if (u.getEmail().equals(mail)) {
                    return true;
                }

            }
        } catch (EOFException ex) {
            return false;
        }
    }

    public static void add(User u) throws FileNotFoundException, IOException {
        File f2= new File("Users//users.txt");
        FileOutputStream f1= new FileOutputStream(f2, true);
        if(f2.length()==0){
        ObjectOutputStream f = new ObjectOutputStream(f1);
        f.writeObject(u);
        f.close();}
        else
        {
            AppendingObjectOutputStream f = new AppendingObjectOutputStream(f1);
            f.writeObject(u);
            f.close();
        }
    }

    public static boolean UserNameQuery(String username) throws IOException, ClassNotFoundException {
        
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));){
            while (true) {
                User u = (User) f.readObject();
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
        
        User u=null;
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));){
            while (true) {
                u = (User) f.readObject();
                if (u.getID()==ID) {
                    break;
                }

            }
        } catch (EOFException ex) {
        } finally {
            return u.getIdentity();
        }
    }


    public static User retrieve(User user, int Id) throws IOException, ClassNotFoundException {
        
//        User u;
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));){
            while (true) {
                user = (User) f.readObject();
                if (user.getID()==Id) {
//                    user = u;
                    return user;
//                    break;
                }

            }
        } catch (EOFException ex) {
        }
        return user;
    }
    public static int UserQuery(String username, String password) throws IOException, ClassNotFoundException
    {
        User u;
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream("Users//users.txt"));){
            while (true) {
//                if (user instanceof Student) {
//                    u = (Student) f.readObject();
//                } else if (user instanceof Teacher) {
//                    f.reset();
                    u = (User) f.readObject();
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
