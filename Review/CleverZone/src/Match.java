import java.util.Vector;

public class Match extends Game {

	Vector<MatchQuestion>Questions;
	
	Match()
	{
		super("", "");
		Questions=new Vector<MatchQuestion>();
	}
	
	Match(String name, String subject)
	{
		super(name, subject);
		Questions=new Vector<MatchQuestion>();
	}
	public Vector<MatchQuestion> GetQuestions() {
		return Questions;
	}
	public void AddQuestion(MatchQuestion x)
	{
		Questions.add(x);
	}

	@Override
	public String toString() {
		return super.toString()+"Match [Questions=" + Questions + "]";
	}
	
	
}