/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edugame;

import static edugame.Edugame.input;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author musta
 */
public class TeacherHomePage extends Homepage {

    public TeacherHomePage(Teacher u) throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("Choose an operation:\n1-Play.\n2-Add a game.");
        int choice = input.nextInt();
        while (choice < 0 || choice > 2) {
            System.out.println("Invalid Input, Enter a valid value: ");
            choice = input.nextInt();
        }
        if (choice == 0) {
            System.exit(0);
        } else if (choice == 1) {
            HomePageControl hpc= new HomePageControl(u);
            hpc.ChooseGame();
        }
        else{
            GameBuilder gb = new GameBuilder();
            gb.AddGame( u);
        }
    }

}
