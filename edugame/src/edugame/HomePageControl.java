
import edugame.Category;
import edugame.Game;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KarimEhab
 */
public class HomePageControl {
    
    public HomePageControl() {
    }
    
    ArrayList <Category> ListofCategories= new ArrayList<Category> ();
 
        public ArrayList<Category> getListofCategories() {
        return ListofCategories;
    }
        public  ArrayList<String> AccessCategory (String CategoryName) throws FileNotFoundException
      {
            ArrayList<String> Names = new ArrayList<>();
           File file=new File(CategoryName);
          if (file.isDirectory())
          {
         Names = new ArrayList<>(Arrays.asList(file.list()));
              
          }
      return Names;
    }
    public Game LoadGamePage (String GameName,String CategoryName)
    {
         File file=new File(CategoryName);
          if (file.isDirectory())
          {
             file = new File(CategoryName+"\\"+GameName);
             Game game;
             GameDBModel.RetrieveGame(game,GameName);
          }
    }
}
