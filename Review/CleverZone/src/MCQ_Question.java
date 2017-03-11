import java.util.Arrays;

public class MCQ_Question{
	private String Question;
	private String Answer;
	String choices[];
	MCQ_Question(String q,String a,String arr[])
	{
		choices=new String[4];
		for(int i=0 ; i<4 ; i++)
			choices[i]=arr[i];
		Question=q;
		Answer=a;
	}
	MCQ_Question()
	{
		choices=new String[4];
		for(int i=0 ; i<4 ; i++)
			choices[i]="";
		Question="";
		Answer="";
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
		Answer=s;
	}
	public String GetAnswer()
	{
		return Answer;
	}
	@Override
	public String toString() {
		return "MCQ_Question [Question=" + Question + ", Answer=" + Answer + ", choices=" + Arrays.toString(choices)
				+ "]";
	}
	
}
