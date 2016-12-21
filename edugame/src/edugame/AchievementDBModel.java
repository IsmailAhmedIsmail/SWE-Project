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
 * @author Alaa
 */
public class AchievementDBModel  {
    public static Achievements RetrieveAch(Achievements ach) throws FileNotFoundException, IOException, ClassNotFoundException{
        int UserID= ach.getUser().getID();
        int GameID= ach.getGame().getID();
        File f = new File("Achievements\\"+UserID+"-"+GameID+".txt");
        if(!f.exists())
        {
            ach.setLastlevel(0);
            UpdateAch(ach);
        }
        else
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            ach = (Achievements) in.readObject();
            in.close();
        }
        return ach;
    }
    
    public static void UpdateAch(Achievements ach) throws FileNotFoundException, IOException{
        int UserID= ach.getUser().getID();
        int GameID= ach.getGame().getID();
        File f = new File("Achievements\\"+UserID+"-"+GameID+".txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(ach);
        oos.close();
    }
}
