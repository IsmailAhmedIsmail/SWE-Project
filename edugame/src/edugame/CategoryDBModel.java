
package edugame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class CategoryDBModel {
    public ArrayList<String> RetrieveCategoryList() throws FileNotFoundException, IOException{
        ArrayList<String> CategoryList= new ArrayList<String>();
        
 	FileInputStream file=new FileInputStream("Categories.txt");
        DataInputStream data=new DataInputStream(file);
        BufferedReader br=new BufferedReader(new InputStreamReader(data));
        
        for(String line; (line = br.readLine()) != null; ) {
        {   
       
            
            CategoryList.add(line);
        }

    }
                return CategoryList;


    }
    public static void UpdateCategory(){
        
    }
}
