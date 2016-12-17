
package edugame;

import java.io.Serializable;

public class GameControl implements Serializable{
    private Game game;
    public GameControl() {
    }

//    public void Addgame(int teacherID){
//        
//    }
//    public void intialgame(String ID){
//        
//    }
    public void intilalizarray(int gameID, int UserID){
        //to intialize the list of levels in this game to this user with his last aahivement
        
    }
    
    public void loadLevel(int levelindex)
    {
        Level l=game.getListofLevels().get(levelindex);
        l.setNumber(levelindex);
        GameDBModel.Retrieve(l, game.getName(), );
    }
}
