/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author KarimEhab
 */
public class Game implements Serializable {
    private int ID;
    private String name;
    private String type;
    private transient ArrayList <Level> ListofLevels= new ArrayList<Level> ();
    private Teacher Owner;
    private int Levelno;
    public Game() {
        ListofLevels= new ArrayList<>();
        
    }
    public Game(int Levelno, String name, String type, Teacher Owner) {
        this.ID= (int) new Date().getTime();
        this.name = name;
        this.type = type;
        this.Owner = Owner;
        this.Levelno=Levelno;
        ListofLevels= new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Game{" + "ID=" + ID + ", name=" + name + ", type=" + type + ", ListofLevels=" + ListofLevels + ", Owner=" + Owner + ", Levelno=" + Levelno + '}';
    }
    
    public int getID() {
        return ID;
    }

    public int getLevelno() {
        return Levelno;
    }

    public void setLevelno(int Levelno) {
        this.Levelno = Levelno;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Level> getListofLevels() {
        return ListofLevels;
    }

    public void setListofLevels(ArrayList<Level> ListofLevels) {
        this.ListofLevels = ListofLevels;
    }

    public void setListofLevels(Level level) {
        this.ListofLevels .add(level);
    }

    public Teacher getOwner() {
        return Owner;
    }

    public void setOwner(Teacher Owner) {
        this.Owner = Owner;
    }
    
    public Level getlevel(int levelindex)
    {
        Level CurrentLevel=  ListofLevels.get(levelindex);
        return CurrentLevel;
    }
      public boolean CheckAnswer (int LevelIndex, String ans)
      {
          Level CheckingLevel= getlevel(LevelIndex);
          if(ans.equals(CheckingLevel.getRightAnswer()))
          {
              return true;
          }
          else 
              return false;
      }
}
