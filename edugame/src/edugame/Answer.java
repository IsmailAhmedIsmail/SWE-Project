
package edugame;

import java.io.Serializable;


public class Answer implements Serializable{
    private String Answer;
//    private File Image;

    public Answer() {
    }

    public Answer(String Answer) {
        this.Answer = Answer;
//        this.Image = Image;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

//    public File getImage() {
//        return Image;
//    }

//    public void setImage(File Image) {
//        this.Image = Iamge;
//    }
    
}
