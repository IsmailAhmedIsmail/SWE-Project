/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.Serializable;

/**
 *
 * @author musta
 */
public class MCQ extends Level implements Serializable{

    public MCQ() {
    }

    public MCQ(String name, String Question, String RightAnswer) {
        super(name, Question, RightAnswer);
    }
    
}
