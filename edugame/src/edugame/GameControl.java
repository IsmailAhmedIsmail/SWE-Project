
package edugame;

import java.io.FileNotFoundException;
import java.io.IOException;
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
//    public void intilalizarray(int gameID, int UserID){
//        //to intialize the list of levels in this game to this user with his last aahivement
//        
//    }
    public void startGame(Game g, User u) throws IOException, FileNotFoundException, ClassNotFoundException{
        GamePage gp = new GamePage();
        game = g;
        Achievements ach = new Achievements();
        ach.setGame(g);
        ach.setUser(u);
        ach = AchievementDBModel.RetrieveAch(ach);
        int selectedLvl=gp.selectLevel(ach.getLastlevel(), g.getLevelno());
        Level l; int selectedAnswer;
        for(int i=selectedLvl;i<game.getLevelno();i++)
        {
            l= game.getListofLevels().get(selectedLvl);
            selectedAnswer=gp.ShowLevel(l);
            while(selectedAnswer!=l.getRightAnswer())
            {
                gp.ShowMsg("Wrong Answer. Please try again.");
                selectedAnswer=gp.ShowLevel(l);
            }
            gp.ShowMsg("Corrrrrrect!");
            if(i+1>ach.getLastlevel() && i+1<game.getLevelno())
            {
                ach.setLastlevel(i+1);
                AchievementDBModel.UpdateAch(ach);
            }
        }
        gp.ShowMsg("Con3'orrratulations! You have affelt elGaaame!");
    }
//    public void loadLevel(int levelindex,int lastindex)
//    {
//        Level l=game.getListofLevels().get(levelindex);
//        l.setNumber(levelindex);
//        GameDBModel.Retrieve(l, game.getName(), );
//    }
    
    public void validateAnswer(int levelIndex, String userAnswer){
        if(game.CheckAnswer(levelIndex, userAnswer)){
//            AchievementDBModel.UpdateAch(Ach, levelIndex, userAnswer);
        }
        else{
            GamePage.ShowMsg("Re-Enter your Answer");
        }
    }
    
    
}
