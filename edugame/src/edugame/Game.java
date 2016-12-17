/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.util.ArrayList;

/**
 *
 * @author KarimEhab
 */
public class Game {
    String ID;
    String name;
    String type;
    ArrayList <Level> ListofLevels= new ArrayList<Level> ();
    Teacher Owner;
public Game() {
        
    }
    public Game(String ID, String name, String type, Teacher Owner) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.Owner = Owner;
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

    public void setListofLevels(ArrayList<Level> ListofLevels) {
        this.ListofLevels = ListofLevels;
    }

    public Teacher getOwner() {
        return Owner;
    }

    public void setOwner(Teacher Owner) {
        this.Owner = Owner;
    }
    
    public Level getlevel(int levelindex)
    {
        Level CurrentLevel=  ListOfLevels.get(levelindex);
        return CurrentLevel;
    }
    public void  addlevel (Level newlevel)
    {
        ListOfLevels.add(newlevel);
        
    }
      public boolean CheckAnswer (int LevelIndex, Answer ans)
      {
          Level CheckingLevel= getlevel(LevelIndex);
          if(ans.answer.equalsto(CheckingLevel.RightAnswer))
          {
              return true;
          }
          else 
              return false;
      }
}
