/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.Serializable;

/**
 *
 * @author KarimEhab
 */
public class Achievements implements Serializable {
    transient Game game;
    transient User user;
    int lastlevel;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLastlevel() {
        return lastlevel;
    }

    public void setLastlevel(int lastlevel) {
        this.lastlevel = lastlevel;
    }
 public Achievements()
 {
     
 }
 
    public Achievements(Game game, User user, int lastlevel) {
        this.game = game;
        this.user = user;
        this.lastlevel = lastlevel;
    }
    
    
    
}
