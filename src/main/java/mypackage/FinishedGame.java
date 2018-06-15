package mypackage;

import java.sql.Timestamp;

public class FinishedGame {
    int prize;
    Timestamp ts;

    public FinishedGame(int prize, Timestamp ts) {
        this.prize = prize;
        this.ts = ts;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }
}
