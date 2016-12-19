
package edugame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class CategoryDBModel {
    public static ArrayList<String> RetrieveCategoryList() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<String> CategoryList= new ArrayList<String>();
        File f = new File("Categories");
        if(!f.exists()){
            f.mkdirs();
        }
        FileOutputStream fileo=new FileOutputStream("Categories//Categories.txt", true);
        fileo.close();
 	FileInputStream file=new FileInputStream("Categories//Categories.txt");
//        DataInputStream data=new DataInputStream(file);
//        BufferedReader br=new BufferedReader(new InputStreamReader(data));
//        
        
        try(ObjectInputStream ois= new ObjectInputStream(file);) {
            while (true) {
               Category c = (Category)ois.readObject();
               CategoryList.add(c.getName());
                }

            }
         catch (EOFException ex) {
            return CategoryList;
        }

    }
    public static void addCategory(String catName) throws FileNotFoundException, IOException{
        File dirs = new File("Categories");
        dirs.mkdirs();
        File f= new File("Categories//Categories.txt");
        Category c = new Category();
        c.setName(catName);
        FileOutputStream f1= new FileOutputStream(f, true);
        if(f.length()==0){
        ObjectOutputStream oos = new ObjectOutputStream(f1);
        oos.writeObject(c);
        oos.close();}
        else
        {
            AppendingObjectOutputStream aoos = new AppendingObjectOutputStream(f1);
            aoos.writeObject(c);
            aoos.close();
        }
        
    }
}
