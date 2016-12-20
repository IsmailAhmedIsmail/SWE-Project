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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author musta
 */
public class GameDBModel {

    public static Game RetrieveGame(Game game, String name) throws IOException, ClassNotFoundException {
        File f = new File("Games\\" + name + "\\" + game.getName() + "\\info.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        game = (Game) in.readObject();
        in.close();
        game.setListofLevels(new ArrayList<>());
        ArrayList <Level> lvls=game.getListofLevels();
        System.out.println(game.getLevelno());
        for(int i=0;i<game.getLevelno();i++)
        {
            Level l;
            if(game.getType().equals("MCQ"))
                l= new MCQ();
            else
                l= new TorF();
            l.setNumber(i);
            lvls.add(GameDBModel.Retrieve(l, game.getName(), name));
        }
        return game;
    }

    public static Category RetrieveGames(String Catname, Category c) {
        File f = new File("Games\\" + Catname);
        c.setListofGames(new ArrayList<String>(Arrays.asList(f.list())));
        c.setName(Catname);
        return c;
    }

    public static void AddGame(Game game, String Catname) throws IOException {
        File f = new File("Games\\" + Catname + "\\" + game.getName());
        f.mkdirs();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getAbsolutePath() + "\\info.txt"));
        oos.writeObject(game);
        oos.close();
        SaveLevel(game,Catname);

    }

    public static Level Retrieve(Level lev, String Gamename, String Catname) throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("Games\\" + Catname + "\\" + Gamename + "\\Levels" + lev.getNumber() + ".txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        int number = lev.getNumber();
        lev = (Level) ois.readObject();
//        if(lev instanceof MCQ)
//            lev=(MCQ)ois.readObject();
//        else if (lev instanceof TorF)
//            lev=(TorF)ois.readObject();
        lev.setNumber(number);
        return lev;
    }

    public static void SaveLevel(Game game, String Catname) throws FileNotFoundException, IOException {
        ArrayList<Level> tmp = game.getListofLevels();
        File f = new File("Games\\" + Catname + "\\" + game.getName() + "\\Levels");
        ObjectOutputStream oos;
        if (!f.exists()) {
            f.mkdirs();
        }
        for (int i = 0; i < tmp.size(); i++) {
            oos = new ObjectOutputStream(new FileOutputStream(f.getAbsolutePath() + "\\" + (i + 1) + ".txt"));
            oos.writeObject(tmp.get(i));
            oos.close();
        }
    }

    public static boolean GameQuery(String Gamename, String Categoryname) throws IOException, ClassNotFoundException {
        Game game;
        try {
            File f = new File("Games\\" + Categoryname + "\\" + Gamename + "\\info.txt");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            game = (Game) in.readObject();
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }
}
