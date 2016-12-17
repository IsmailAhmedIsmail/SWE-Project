/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author KarimEhab
 */
public class Game {
    String ID;
    String name;
    String type;
    transient ArrayList <Level> ListofLevels= new ArrayList<Level> ();
    Teacher Owner;
    int Levelno;
    public Game() {
        
    }
    public Game(int Levelno, String name, String type, Teacher Owner) {
        this.ID = ID= String.valueOf(Date.from(Instant.EPOCH).getTime());
        this.name = name;
        this.type = type;
        this.Owner = Owner;
        this.Levelno=Levelno;
        
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
    public void  addlevel (Level newlevel)
    {
        ListofLevels.add(newlevel);
        
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
