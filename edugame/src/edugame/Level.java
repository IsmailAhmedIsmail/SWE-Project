/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author musta
 */
public abstract class Level implements Serializable{
    private String name;
    private String Question;
    transient private int number;
    private List<Answer> Answers;
    private int RightAnswer ;

    public Level() {
        Answers= new ArrayList<>();
    }

    public Level(String name, String Question, int RightAnswer) {
        this.name = name;
        this.Question = Question;
        this.RightAnswer = RightAnswer;
        Answers= new ArrayList<>();
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

    public int getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(int RightAnswer) {
        this.RightAnswer = RightAnswer;
    }
    
}
