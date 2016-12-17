/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author KarimEhab
 */
public class Category implements Serializable {
   public String name;
  public  ArrayList <Game> ListofGames= new ArrayList<Game> ();
 public Category()
 {
     
 }
    public Category(String name,ArrayList<Game> ListofGames) {
        this.name = name;
        this.ListofGames = ListofGames;
    }
 
     

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Game> getListofGames() {
        return ListofGames;
    }

    public void setListofGames(ArrayList<Game> ListofGames) {
        this.ListofGames = ListofGames;
    }
    public void  Addto (Game game)
    {
        ListofGames.add(game);
             
    }
      
}
