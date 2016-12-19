
package edugame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameBuilder {
    static Scanner input = new Scanner(System.in);
    static BuilderControl bc = new BuilderControl();
    
    public static String GetName(){
        System.out.print("Enter the name: ");
        return input.nextLine();
    }
    public static String SelectCategory() throws IOException, FileNotFoundException, ClassNotFoundException{
        HomePageControl hpc = new HomePageControl();
        ArrayList<String> CatNames = hpc.getListofCategories();
        System.out.println("Categories are:");
        for(int i=0; i<CatNames.size(); i++){
            System.out.println((i+1)+"- "+CatNames.get(i));
        }
        System.out.print("0- others\nPress the number of Category to add your game to: ");
        int num = input.nextInt();
        while(num<0 || num>CatNames.size())
        {
            System.out.println("Invalid Number, Please Insert a valid number: ");
            num = input.nextInt();
        }
        String name;
        input.nextLine();
        if(num == 0){
            
            System.out.print("Enter the category name: ");
            name = input.nextLine();
            bc.CreateCategory(name);
        }
        else{
            name = CatNames.get(num-1);
        }
        return name;
    }
    public static String GetType(){
        System.out.print("Enter the game type (MCQ) (T/F): ");
        return input.nextLine();
    }
    public static int GetNoLevel(){
        System.out.print("Enter the number of levels: ");
        return input.nextInt();
    }
    public static String GetQuestion(){
        System.out.print("Enter the question: ");
        return input.nextLine();
    }
    public static String GetAnswer(){
        System.out.print("Enter a possible answer: ");
        return input.nextLine();
    }
    public static int GetRightAnswer(){
        System.out.print("Enter the number of the right answer: ");
        int tmp =  input.nextInt();
        input.nextLine();
        return tmp;
    }
//    public static void GetImage (){
//        
//    }
    public void AddGame(Teacher t) throws IOException, ClassNotFoundException{
        String catName = SelectCategory();
        String gameName = GetName();
        while(bc.CheckDuplicate(gameName, catName)){
            System.out.println("Game name already exists!");
            GetName();
        }
        String type = GetType();
        int n = GetNoLevel();
        input.nextLine();
        bc.CreateGame(catName,gameName, n, type, t);
        System.out.println("Game is successfully added!");
    }
}
