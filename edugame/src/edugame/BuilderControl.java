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

    public static boolean CheckDuplicate(String gameName, String categoryName) throws IOException, ClassNotFoundException {

        return GameDBModel.GameQuery(gameName, categoryName);
    }

    public static void CreateGame(String catName,String gameName, int levelNo, String type, Teacher Owner) throws IOException {
        Game game = new Game(levelNo, gameName, type, Owner);
        for (int i = 0; i < levelNo; i++) {
            String levelName = GameBuilder.GetName();
            String question = GameBuilder.GetQuestion();
            if (type.equals("MCQ")) {
                MCQ lv = new MCQ();
                for (int j = 0; j < 4; j++) {
                    Answer ans = new Answer(GameBuilder.GetAnswer());
                    lv.setAnswers(ans);
                }
//                lv = new MCQ(levelName, question, GameBuilder.GetRightAnswer());
                lv.setName(levelName);
                lv.setQuestion(question);
                lv.setNumber(i+1);
                lv.setRightAnswer(GameBuilder.GetRightAnswer()-1);
                game.setListofLevels(lv);
            } else {
                TorF lv = new TorF(levelName, question, GameBuilder.GetRightAnswer());
                lv.setNumber(i+1);
            }
        }
       GameDBModel.AddGame(game, catName);
    }

    public static void CreateCategory(String catName) throws IOException {
        CategoryDBModel.addCategory(catName);
    }

}
