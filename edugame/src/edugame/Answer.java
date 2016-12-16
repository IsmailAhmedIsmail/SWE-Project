
package edugame;

import java.io.File;


public class Answer {
    private String Answer;
    private File Iamge;

    public Answer() {
    }

    public Answer(String Answer, File Iamge) {
        this.Answer = Answer;
        this.Iamge = Iamge;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public File getIamge() {
        return Iamge;
    }

    public void setIamge(File Iamge) {
        this.Iamge = Iamge;
    }
    
}
