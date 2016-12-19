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
   transient public  ArrayList <String> ListofGames= new ArrayList<> ();
 public Category()
 {
     ListofGames= new ArrayList<>();
 }
    public Category(String name,ArrayList<String> ListofGames) {
        this.name = name;
        this.ListofGames = ListofGames;
    }
 
     

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getListofGames() {
        return ListofGames;
    }

    public void setListofGames(ArrayList<String> ListofGames) {
        this.ListofGames = ListofGames;
    }
    public void  Addto (String game)
    {
        ListofGames.add(game);
             
    }
      
}
