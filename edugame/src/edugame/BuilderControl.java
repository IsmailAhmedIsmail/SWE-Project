/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
                int rightAnswer=GameBuilder.GetRightAnswer()-1;
                while(rightAnswer<1 || rightAnswer>4)
                {
                    System.out.println("Invalid Number!");
                    rightAnswer=GameBuilder.GetRightAnswer()-1;
                }
                lv.setRightAnswer(rightAnswer);
                game.setListofLevels(lv);
            } else {
                System.out.println("1-True     2-False");
                int rightAnswer=GameBuilder.GetRightAnswer()-1;
                while(rightAnswer<1 || rightAnswer>2)
                {
                    System.out.println("Invalid Number!");
                    rightAnswer=GameBuilder.GetRightAnswer()-1;
                }
                TorF lv = new TorF(levelName, question, rightAnswer);
                lv.setNumber(i+1);
            }
        }
       GameDBModel.AddGame(game, catName);
    }

    public static void CreateCategory(String catName) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<String> categories =CategoryDBModel.RetrieveCategoryList();
        if(categories.contains(catName))
            System.out.println("Category Already Exists! Your game will be automatically added to it.");
        else
            CategoryDBModel.addCategory(catName);
    }

}
