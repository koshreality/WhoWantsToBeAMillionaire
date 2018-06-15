package mypackage;

public class Answer {
    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    boolean correct;
}