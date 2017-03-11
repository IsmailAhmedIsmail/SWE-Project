import java.util.Vector;

public class T_F extends Game {

	public Vector<T_FQuestion>Questions;
	T_F(String name, String subject)
	{
		super(name, subject);
		Questions=new Vector<T_FQuestion>();
	}
	public T_F() {
		super("","");
		Questions=new Vector<T_FQuestion>();
	}
	public void AddQuestion(T_FQuestion x)
	{
		Questions.add(x);
	}
	public Vector<T_FQuestion> GetQuestions() {
		return Questions;
	}
	@Override
	public String toString() {
		return super.toString()+"T_F [Questions=" + Questions + "]";
	}
	public int size(){
		return Questions.size();
	}
	
	
	
}