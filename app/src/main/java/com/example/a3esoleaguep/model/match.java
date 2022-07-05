package com.example.a3esoleaguep.model;

public class match {
    String firstTeam , secondTeam;
    int id ,firstScore, secondScore;

    public match(int id,String firstTeam, String secondTeam, int firstScore, int secondScore) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.id = id;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(int firstScore) {
        this.firstScore = firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(int secondScore) {
        this.secondScore = secondScore;
    }
}
