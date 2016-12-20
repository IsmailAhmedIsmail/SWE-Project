
package edugame;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GamePage {

    static Scanner input = new Scanner(System.in);
    
    public GamePage() {
    }
    
//    public static Level Showlevels(List<Level> levels){
//        return null;
//    }
    
    public static int ShowLevel(Level level){
        System.out.println(level.getName());
        System.out.println(level.getQuestion());
        int selectedAnswer;
        if(level instanceof MCQ)
        {
            for(int i=0;i<level.getAnswers().size();i++)
            {
                System.out.println((i+1)+"- "+level.getAnswers().get(i).getAnswer());
            }
            
        }
        else
        {
            System.out.println("1- True\n2- False");
        }
        System.out.println("Enter the number of your answer: ");
        selectedAnswer= input.nextInt();
        if(level instanceof MCQ)
        {
            while(selectedAnswer<1 || selectedAnswer>4)
            {
                System.out.println("Invalid Choice, enter a valid number.");
                selectedAnswer=input.nextInt();
            }
        }
        else
        {
            while(selectedAnswer<1 || selectedAnswer>2)
            {
                System.out.println("Invalid Choice, enter a valid number.");
                selectedAnswer=input.nextInt();
            }
        }
        return selectedAnswer-1;
    }
    public static void ShowMsg(String msg){
        System.out.println(msg);
    }
    public static int selectLevel(int lastLevel, int levelsno){
        System.out.println("The game has "+levelsno+"\nSelect a level from 1 to "+(lastLevel+1));
        int num= input.nextInt()-1;
        while(num<1 || num>lastLevel)
        {
            System.out.println("Level is locked! Please Select an available level");
            num=input.nextInt();
        }
        return num;
    }
    public void PlayGame(User u) throws IOException, ClassNotFoundException{
        Homepage hp;
        if(u.getIdentity().equals("Student")){
            hp = new Homepage();
        }
        else{
            hp = new TeacherHomePage();
        }
        Game g = hp.chooseCategory();
        GameControl gc = new GameControl();
        gc.startGame(g, u);
        
    }
}
