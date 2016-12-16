/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author musta
 */
public class GameDBModel {

    public static void RetrieveGame(Game game, String name) throws IOException {
        File f = new File("Games\\" + name + "\\" + game.getName() + "\\info.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        game = (Game) in.readObject();
        in.close();
    }

    public static void RetrieveGames(String Catname, Category c) {
        File f = new File("Games\\" + Catname);
        c.setList(Arrays.asList(f.list()));
    }

    public static void AddGame(Game game, String Catname) throws IOException {
        File f = new File("Games\\" + Catname + "\\" + game.getName());
        f.mkdirs();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getAbsolutePath() + "\\info.txt", true));
        oos.writeObject(game);
        oos.close();
        ArrayList<Level> tmp = game.getList();
        f = new File("Games\\" + Catname + "\\" + game.getName() + "\\Levels");
        f.mkdirs();
        for (int i = 0; i < tmp.size(); i++) {
            oos = new ObjectOutputStream(new FileOutputStream(f.getAbsolutePath() + "\\" + (i + 1) + ".txt"));
            oos.writeObject(tmp.get(i));
            oos.close();
        }
    }

    public static void Retrieve(Level lev) {

    }

    public static void SaveLevel(List<Level> levels) {

    }
}
