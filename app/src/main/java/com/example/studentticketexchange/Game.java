package com.example.studentticketexchange;

import java.util.Date;

public class Game {
    public String sport;
    public String opponent;
    public int month;
    public int day;

    public Game() {

    }

    public Game(String sport, String opponent, int month, int day) {
        this.sport = sport;
        this.opponent = opponent;
        this.month = month;
        this.day = day;
    }
}
