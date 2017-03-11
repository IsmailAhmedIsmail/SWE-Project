
public class T_FQuestion {
	private String Question;
	private String Answer;
	T_FQuestion(String q,String s)
	{
		if(s.charAt(0)=='t' || s.charAt(0)=='T')	s="True";
		if(s.charAt(0)=='f' || s.charAt(0)=='F')	s="False";
		Question=q;
		Answer=s;
	}
	public void SetQuestion(String s)
	{
		Question=s;
	}
	public String GetQuestion()
	{
		return Question;
	}
	public void SetAnswer(String s)
	{
		if(s.charAt(0)=='t' || s.charAt(0)=='T')	s="True";
		if(s.charAt(0)=='f' || s.charAt(0)=='F')	s="False";
		Answer=s;
	}
	public String GetAnswer()
	{
		return Answer;
	}
	@Override
	public String toString() {
		return "T_FQuestion [Question=" + Question + ", Answer=" + Answer + "]";
	}
	
}
