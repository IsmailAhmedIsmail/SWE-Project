import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class DataBaseGame {
	
	
	Vector<T_F>TFGames;
	Vector<Match>MatchGames;
	Vector<McQ>McQGames;
	Set<String> AllSub;
	Map<String,Game> allGames;
	private String ConnectionString;
	
	
	public DataBaseGame() {
		TFGames = new Vector<T_F>();
		MatchGames = new Vector<Match>();
		McQGames = new Vector<McQ>();
		AllSub = new HashSet<String>();
		allGames = new HashMap<String,Game>();
	}
	public boolean checkGameName(String na){
		return allGames.containsKey(na);
	}

	/**
	 * 
	 * @param game
	 * @param String
	 */
	public boolean AddGameToDB(Game game) {
		if(game instanceof T_F){
			TFGames.addElement((T_F) game);
		}else if(game instanceof McQ){
			McQGames.addElement((McQ) game);
		}else if(game instanceof Match){
			MatchGames.addElement((Match) game);
		}
		//System.out.println(game);
		allGames.put(game.getName() , game);
		AllSub.add(game.getSubject());
		return true;
	}

	public Vector<String> AllSubject(int choice) {
		Vector<String> ret = new Vector<String>();
		Set<String>s=new HashSet<String>();
		if(choice == 0){
			for(int i=0;i<TFGames.size();i++){
						s.add(TFGames.get(i).getSubject());
			}
		}else if(choice == 1){
			for(int i=0;i<MatchGames.size();i++){
				s.add(MatchGames.get(i).getSubject());
			
			}
		}else if(choice == 2){
			for(int i=0;i<McQGames.size();i++){
				s.add(McQGames.get(i).getSubject());
		}
		}
		for(String x : s)
			ret.add(x);
		return ret;
	}
	public Game getGame(String name){
		return allGames.get(name);
	}
	


	/**
	 * 
	 * @param catogriesID
	 * @param SubjectID
	 */
	public Vector<Game> AllGame(int catID, String Subject) {
		Vector<Game> ret = new Vector<Game>();
		if(catID == 0){
			for(int i=0;i<TFGames.size();i++){
				if(TFGames.get(i).getSubject().equals(Subject)||Subject.equals("G")){
						ret.addElement(TFGames.get(i));
				}

			}
		}else if(catID == 1){
			for(int i=0;i<MatchGames.size();i++){
				if(MatchGames.get(i).getSubject().equals(Subject)||Subject.equals("G")){
					ret.addElement(MatchGames.get(i));
			}
			}
		}else if(catID == 2){
			for(int i=0;i<McQGames.size();i++){
				if(McQGames.get(i).getSubject().equals(Subject)||Subject.equals("G")){
					ret.addElement(McQGames.get(i));
			}
		}
		}
		return ret;
	}



}