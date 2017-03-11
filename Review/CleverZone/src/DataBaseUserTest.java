import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataBaseUserTest {

  @Test (dataProvider="CheckDataTest")
  public void CheckData(Account a, boolean result) {
	  DataBaseUser db = new DataBaseUser();
	  assertEquals(db.CheckData(a), result);
  }
  @DataProvider (name="CheckDataTest")
  public Object[][] CheckDatadp() throws FileNotFoundException{
	  Object [] accounts= SaveAccountdp();
	  Object result[][]= new Object[accounts.length][];
	  Scanner input = new Scanner (new File ("CheckDataTest.txt"));
	  for(int i=0;i<accounts.length;i++)
	  {
		  result[i]= new Object[] {accounts[i],input.nextBoolean()};
		  input.nextLine();
	  }
	  input.close();
	  return result;
  }
  @DataProvider (name="DataBaseUserTest")
  public Object[] SaveAccountdp() throws FileNotFoundException
  {
	  Scanner input = new Scanner ( new File ("Accounts.txt"));
	  ArrayList<Account> list= new ArrayList<>();
	  while(input.hasNext())
	  {
		  Account temp= new Account();
		  temp.setUsername(input.nextLine());
		  temp.setPassword(input.nextLine());
		  temp.setEmail(input.nextLine());
		  temp.setType(input.nextBoolean());
		  String garbage = input.nextLine();
		  list.add(temp);
	  }
	  input.close();
	  return list.toArray(new Object[list.size()]);
  }
  @Test (dataProvider="DataBaseUserTest")
  public void SaveAccount_Test(Account a) {
	  DataBaseUser db = new DataBaseUser();
	  db.SaveAccount(a);
	  assertEquals(db.Checklogin(a.getUsername(), a.getPassword()), true);
		  
  }
}
