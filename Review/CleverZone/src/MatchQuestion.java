import java.util.Vector;

public class MatchQuestion {
	public Vector<String>QuestionA;
	public Vector<String>QuestionB;
	public Vector<String>AnswerA;
	public Vector<String>AnswerB;
	MatchQuestion(Vector<String>Questiona,Vector<String>Questionb,Vector<String>Answera,Vector<String>Answerb)
	{
		QuestionA.clear();QuestionB.clear();AnswerA.clear();AnswerB.clear();
		for(int i=0 ; i<Questiona.size() ; i++)
			QuestionA.add(Questiona.get(i));
		for(int i=0 ; i<Questionb.size() ; i++)
			QuestionB.add(Questionb.get(i));
		for(int i=0 ; i<Answera.size() ; i++)
			AnswerA.add(Answera.get(i));
		for(int i=0 ; i<Answerb.size() ; i++)
			AnswerB.add(Answerb.get(i));		
	}
	MatchQuestion()
	{
		QuestionA = new Vector<String>();
		QuestionB = new Vector<String>();
		AnswerA = new Vector<String>();
		AnswerB = new Vector<String>();
	}
	public void SetQuestionA(Vector<String>Questiona)
	{
		QuestionA.clear();
		for(int i=0 ; i<Questiona.size() ; i++)
			QuestionA.add(Questiona.get(i));
	}
	public void SetQuestionB(Vector<String>Questionb)
	{
		QuestionB.clear();
		for(int i=0 ; i<Questionb.size() ; i++)
			QuestionB.add(Questionb.get(i));
	}
	public void SetAnswerA(Vector<String>Answera)
	{
		AnswerA.clear();
		for(int i=0 ; i<Answera.size() ; i++)
			AnswerA.add(Answera.get(i));
	}
	public void SetAnswerB(Vector<String>Answerb)
	{
		AnswerB.clear();
		for(int i=0 ; i<Answerb.size() ; i++)
			AnswerB.add(Answerb.get(i));
	}
	public Vector<String> GetQuestionA()
	{
		return QuestionA;
	}
	public Vector<String> GetQuestionB(Vector<String>Questionb)
	{
		return QuestionB;
	}
	public Vector<String> GetAnswerA(Vector<String>Answera)
	{
		return AnswerA;
	}
	public Vector<String> GetAnswerB(Vector<String>Answerb)
	{
		return AnswerB;
	}
	public String getStr(char x){
		x = Character.toUpperCase(x);
		return (QuestionB.get(x-'A') );
	}
	@Override
	public String toString() {
		return "MatchQuestion [QuestionA=" + QuestionA + ", QuestionB=" + QuestionB + ", AnswerA=" + AnswerA + "]";
	}
	

	
}
