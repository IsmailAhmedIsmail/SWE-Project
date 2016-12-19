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
public class TorF extends Level implements Serializable {

    public TorF() {
    }

    public TorF(String name, String Question, int RightAnswer) {
        super(name, Question, RightAnswer);
    }
    
}
