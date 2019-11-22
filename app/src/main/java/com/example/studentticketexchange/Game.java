package com.example.studentticketexchange;

import java.util.Calendar;

public class Game implements Comparable<Game>{
    public int sport; //1 for football, 2 for basketball , 3 for hockey
    public String opponent;
    public int month;
    public int day;
    public int year;

    public Game() {

    }

    public Game(int sport, String opponent, int month, int day, int year) {
        this.sport = sport;
        this.opponent = opponent;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public int compareTo(Game game) {
        if(this.year == game.year){
            if(this.month == game.month){
                return this.day - game.day;
            } else {
                return this.month - game.month;
            }
        } else{
            return this.year - game.year;
        }
    }
}
