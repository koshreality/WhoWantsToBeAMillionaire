package mypackage;

public class Answer {
    String text;
    boolean correct;
    String add;

    public Answer(String text, boolean correct, String add) {
        this.text = text;
        this.correct = correct;
        this.add = add;
    }

    public Answer(String text, boolean correct) {
        this.add = "";
        this.text = text;
        this.correct = correct;
    }

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

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}