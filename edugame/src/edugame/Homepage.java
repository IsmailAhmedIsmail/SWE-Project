
package edugame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homepage {

    public Homepage() {
    }
    
    public static void ChooseCategoryID(String categoryID){
        
    }
    public static void ShowCategories(String ListofCat){
        
    }
    public Game chooseCategory() throws IOException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        HomePageControl hpc = new HomePageControl();
        ArrayList<String> CatNames = hpc.getListofCategories();
        System.out.println("Categories are:");
        for(int i=0; i<CatNames.size(); i++){
            System.out.println((i+1)+"- "+CatNames.get(i));
        }
        System.out.print("Press the number of Category to choose it: ");
        int num = input.nextInt();
        List<String> GamesNames = hpc.AccessCategory(CatNames.get(num-1));
        System.out.println("Games in this category are:");
        for(int i=0; i<GamesNames.size(); i++){
            System.out.println((i+1)+"- "+GamesNames.get(i));
        }
        System.out.print("Press the number of Game to choose it: ");
        int number = input.nextInt();
         return ChooseGame(GamesNames.get(number-1), CatNames.get(num-1));
    }
    public Game ChooseGame(String GameName, String CatName) throws IOException, ClassNotFoundException{
        HomePageControl hpc = new HomePageControl();
        Game game = hpc.LoadGamePage(GameName, CatName);
        return game;
    }
}
