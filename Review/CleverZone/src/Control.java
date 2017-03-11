import java.util.Vector;
 
public class Control {
 
	private DataBaseUser data;
	private DataBaseGame dataGame;
 
	/**
	 * 
	 * @param Account
	 */
	Control()
	{
		
		data=new DataBaseUser();
		dataGame = new DataBaseGame();
		Student s=new Student("111","111","111@",true);
		Teacher t=new Teacher("222","222","222@",false);
		data.SaveAccount(s);data.SaveAccount(t);
		Match m1=new Match("NewMatchGame","math");
		McQ m2=new McQ("NewMcQGame","english");
		T_F m3=new T_F("NewT_FGame","math");
	}

	
	public boolean ValidateData(Account Account) {
		if(data.CheckData(Account)){
			return data.SaveAccount(Account);
		}else{
			return false;
		}
 
 
	}
	public Game getGame(String x){
		return dataGame.getGame(x);
	}
 
	/**
	 * 
	 * @param game
	 * @param subject
	 */
	public boolean AddGame(Game game) {
		return dataGame.AddGameToDB(game);
	}
 
	public Vector<String> GetallSubject(int x) {
		return dataGame.AllSubject(x);
	}
 
	public Game GetallCatogries() {
		// TODO - implement Control.GetallCatogries
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param catogry
	 * @param subject
	 */
	public Vector<Game> GetAllGame(int catogry, String subject) {
		return dataGame.AllGame(catogry, subject);
	}
 
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public boolean CheckType(String a)
	{
		return data.CheckType(a);
	}
 
	public boolean VallidLogin(String username, String password) {
		return data.Checklogin(username, password);
	}
	public Account getAccount(String userN){
		return data.getAccount(userN);
	}
	public boolean checkGameName(String na){
		return dataGame.checkGameName(na);
	}
}
 