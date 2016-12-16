/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author musta
 */
public class Level implements Serializable{
    private String name;
    private String Question;
    private int number;
    private List<Answer> Answers;
    private String RightAnswer ;

    public Level() {
    }

    public Level(String name, String Question, String RightAnswer) {
        this.name = name;
        this.Question = Question;
        this.RightAnswer = RightAnswer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Answer> getAnswers() {
        return Answers;
    }

    public void setAnswers(Answer Ans) {
        this.Answers.add(Ans);
    }

    public String getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(String RightAnswer) {
        this.RightAnswer = RightAnswer;
    }
    
}
