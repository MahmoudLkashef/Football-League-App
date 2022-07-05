package com.example.a3esoleaguep.model;

public class Club {
    String club;
    int GP,points,win,draw,lose,GI,GO;

    public Club(String club, int GP, int points, int win, int draw, int lose, int GI, int GO) {
        this.club = club;
        this.GP = GP;
        this.points = points;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
        this.GI = GI;
        this.GO = GO;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getGP() {
        return GP;
    }

    public void setGP(int GP) {
        this.GP = GP;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getGI() {
        return GI;
    }

    public void setGI(int GI) {
        this.GI = GI;
    }

    public int getGO() {
        return GO;
    }

    public void setGO(int GO) {
        this.GO = GO;
    }
}
