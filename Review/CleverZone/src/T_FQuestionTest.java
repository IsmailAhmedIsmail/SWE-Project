import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;

public class T_FQuestionTest {

  @DataProvider(name = "data")
  public Object[] dp() {
    return new Object[] {
    		"true", "True", "false", "False", "Nothing", "Fire", "Train"
    };
  }

  @Test (dataProvider = "data")
  public void SetAnswer(String s) {
	  T_FQuestion object = new T_FQuestion("", s);
	  assertEquals(s, object.GetAnswer());
  }
}
