package com.brickBracker;

public class Player {
    public String name;
    private int score=0;
    private int floor_no=-1;

    public Player(){ }

    public int getFloor_no() {
        return floor_no;
    }

    public void setFloor_no(int floor_no) {
        this.floor_no = floor_no;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
