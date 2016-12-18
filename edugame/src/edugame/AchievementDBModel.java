/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author musta
 */
public class AchievementDBModel  {
    public static Achievements RetrieveAch(Achievements Ach,int UserID,String GameID) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File("Achievements\\"+UserID+"-"+GameID+".txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Ach = (Achievements) in.readObject();
        in.close();
        return Ach;
    }
    
    public static void UpdateAch(Achievements Ach, int UserID, String GameID) throws FileNotFoundException, IOException{
        File f = new File("Achievements\\"+UserID+"-"+GameID+".txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(Ach);
        oos.close();
    }
}
