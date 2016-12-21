
package edugame;

import static edugame.Edugame.input;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homepage {

    public Homepage() {
    }

    
    public Homepage(User u) throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("1-Play Game\n0-Exit");
        int choice=input.nextInt();
        while(choice<0 || choice>1)
        {
            System.out.println("Invalid Input, Enter a valid value: ");
            choice=input.nextInt();
        }
        if(choice==0)
            System.exit(0);
        else
        {
            HomePageControl hpc= new HomePageControl(u);
//            hpc.ChooseGame();
        }
            
    }
    
    public static int SelectCategory(ArrayList<String> CatNames){
        System.out.println("Categories are:");
        for(int i=0; i<CatNames.size(); i++){
            System.out.println((i+1)+"- "+CatNames.get(i));
        }
        System.out.print("Press the number of Category to choose it: ");
        int choice= input.nextInt();
        while(choice<1 || choice>CatNames.size())
        {
            System.out.println("Invalid Choice. Please enter a valid value:");
            choice= input.nextInt();
        }
        return choice;
    }
    public static int SelectGame(ArrayList<String> GameNames){
        System.out.println("Games are:");
        for(int i=0; i<GameNames.size(); i++){
            System.out.println((i+1)+"- "+GameNames.get(i));
        }
        System.out.print("Press the number of Game to choose it: ");
        int choice= input.nextInt();
        while(choice<1 || choice>GameNames.size())
        {
            System.out.println("Invalid Choice. Please enter a valid value:");
            choice= input.nextInt();
        }
        return choice;
    }
    public static void ShowMsg(String msg) {
        System.out.println(msg);
    }
//    public void chooseCategory() throws IOException, ClassNotFoundException{
//        Scanner input = new Scanner(System.in);
//        HomePageControl hpc = new HomePageControl();
//        ArrayList<String> CatNames = hpc.getListofCategories();
//        ShowCategories(CatNames);
//        
//        List<String> GamesNames = hpc.AccessCategory(CatNames.get(num-1));
//        System.out.println("Games in this category are:");
//        for(int i=0; i<GamesNames.size(); i++){
//            System.out.println((i+1)+"- "+GamesNames.get(i));
//        }
//        System.out.print("Press the number of Game to choose it: ");
//        int number = input.nextInt();
//        hpc.ChooseGame(GamesNames.get(number-1), CatNames.get(num-1));
//         
//         
//    }
    
    
}
