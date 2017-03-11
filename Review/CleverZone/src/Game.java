public class Game {

	private int ID;
	private String Name;
	private String Subject;
	public Game(String name, String subject) {
		super();
		Name = name;
		Subject = subject;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	@Override
	public String toString() {
		return "Game [Name=" + Name + ", Subject=" + Subject + "]";
	}
	


}