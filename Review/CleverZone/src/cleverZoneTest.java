import javax.swing.JTextField;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class cleverZoneTest {
  @DataProvider(name = "data")
  public Object[] dp() {
	    return new Object[] {
	    		"true", "True", "false", "False", "Nothing", "Fire", "Train"
	    };
	  }
	
  @Test(dataProvider = "data")
  public void T_FAnswer(String s) {
	  cleverZone c = new cleverZone();
	  c.getT_fTmpQuesTxtField().setText("QuestionTest");
	  c.getT_fTmpAnsTxtField().setText(s);
	  c.t_fTmpBtnAddQ.doClick();
	  T_F gameTest= c.getTfGame();
//	  gameTest.GetQuestions().get(0).GetAnswer();
	  assert (gameTest.GetQuestions().get(0).GetAnswer().equals("True")) || (gameTest.GetQuestions().get(0).GetAnswer().equals("False"));
  }
}
