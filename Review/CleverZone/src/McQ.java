import java.util.Vector;

public class McQ extends Game {
	
	Vector<MCQ_Question>Questions;
	McQ(String name, String subject)
	{
		super(name, subject);
		Questions=new Vector<MCQ_Question>();
	}
	public McQ() {
		super("","");
		Questions=new Vector<MCQ_Question>();
	}
	public Vector<MCQ_Question> getQuestions() {
		return Questions;
	}
	public void AddQuestion(MCQ_Question x)
	{
		Questions.add(x);
	}
	@Override
	public String toString() {
		return super.toString()+"McQ [Questions=" + Questions + "]";
	}
	
	
	
}