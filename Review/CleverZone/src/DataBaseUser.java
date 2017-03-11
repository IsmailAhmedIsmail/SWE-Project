// de class DataBaseUser
import java.util.HashMap;
import java.util.Vector;
 
public class DataBaseUser {
	private HashMap<String, Account> data;
	private String ConnectionString;
	private Vector<Account>vec;
	
	public DataBaseUser() {
		data = new HashMap<String,Account>();
		vec=new Vector<Account>();
	}
	public String getConnectionString() {
		return this.ConnectionString;
	}
	public Account getAccount(String us){
		return data.get(us);
		
	}
	public boolean CheckType(String a)
	{
		for(int i=0 ; i<vec.size(); i++)
		{
			if(vec.get(i).getUsername().equals(a))
				return vec.get(i).isType();
		}
		return false;
	}
 
	public void setConnectionString(String ConnectionString) {
		this.ConnectionString = ConnectionString;
	}
	/**
	 * 
	 * @param account
	 */
	public boolean SaveAccount(Account account) {
		data.put(account.getUsername(), account);
		vec.addElement(account);
		return true;
	}
	/**
	 * 
	 * @param account
	 */
	public boolean CheckData(Account account) {
		boolean ch = false;
		String em = account.getEmail();
		//System.out.println(em);;
		for(int i=0;i<em.length();i++){
			if(em.charAt(i) == '@'){
				ch = true;
			}
		}
		if(data.containsKey(account.getUsername())){
			return false;
		}else return ch;
	}
	/**
	 * 
	 * @param Username
	 * @param Password
	 */
	public boolean Checklogin(String Username, String Password) {
		if(!data.containsKey(Username)){
			return false;
		}else return (data.get(Username).getPassword().equals(Password));
	}

 
}