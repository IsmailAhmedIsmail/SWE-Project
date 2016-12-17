/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.IOException;

/**
 *
 * @author musta
 */
public class BuilderControl {
       
  public static boolean CheckDuplicate(String gameName , String categoryName) throws IOException, ClassNotFoundException{
      
      return GameDBModel.GameQuery(gameName, categoryName);
  }
  public static void CreateGame(String gameName , int levelNo , String type ,Teacher Owner ){
    Game  game = new Game(levelNo, gameName , type ,Owner );
    for(int i=0;i<levelNo;i++ ){
        if(type .equals( "MCQ")){
            MCQ lv = null;
            for(int j=0;j<4;j++){
                lv= new MCQ(GameBuilder.GetName(),GameBuilder.GetQuestion(),GameBuilder.GetRightAnswer());
                Answer ans = new Answer(Homepage.GetAnswer(),Homepage.GetImage());
                lv.setAnswers(ans);
            }
            game.setListofLevels(lv);
            
        }
        else{
             TorF lv= new TorF(GameBuilder.GetName(),GameBuilder.GetQuestion(),GameBuilder.GetRightAnswer());
        }
    }
  }

  
}
