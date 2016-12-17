
import edugame.Category;
import edugame.CategoryDBModel;
import edugame.Game;
import edugame.GameDBModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    ArrayList<Category> ListofCategories = new ArrayList<Category>();
    public ArrayList<Category> getListofCategories() {
        return ListofCategories;
    }

    public List<String> AccessCategory(String CategoryName) throws FileNotFoundException {
//        ArrayList<String> Names = new ArrayList<>();
//        File file = new File(CategoryName);
//        if (file.isDirectory()) {
//            Names = new ArrayList<>(Arrays.asList(file.list()));
//
//        }
        return CategoryDBModel.RetrieveCategoryList();
    }

    public Game LoadGamePage(String GameName, String CategoryName) throws IOException, ClassNotFoundException {
        File file = new File(CategoryName);
        Game game = new Game();
        if (file.isDirectory()) {
            file = new File(CategoryName + "\\" + GameName);
            GameDBModel.RetrieveGame(game, GameName);
        }
        return game;
    }
}
