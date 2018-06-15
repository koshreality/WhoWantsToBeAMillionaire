package mypackage;

import java.sql.Timestamp;

public class TopUser {
    String username;
    int prize;
    Timestamp ts;

    public TopUser(String username, int prize, Timestamp ts) {
        this.username = username;
        this.prize = prize;
        this.ts = ts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
