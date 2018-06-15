package mypackage;

public class Question {

    int id;
    int difficulty;
    String q;
    String correct;
    String inc1;
    String inc2;
    String inc3;
    String background;

//    public Question() {}

    public Question(int id, int Difficulty, String q, String correct, String inc1, String inc2, String inc3, String background) {
        this.id = id;
        this.difficulty = Difficulty;
        this.q = q;
        this.correct = correct;
        this.inc1 = inc1;
        this.inc2 = inc2;
        this.inc3 = inc3;
        this.background = background;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getInc1() {
        return inc1;
    }

    public void setInc1(String inc1) {
        this.inc1 = inc1;
    }

    public String getInc2() {
        return inc2;
    }

    public void setInc2(String inc2) {
        this.inc2 = inc2;
    }

    public String getInc3() {
        return inc3;
    }

    public void setInc3(String inc3) {
        this.inc3 = inc3;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}