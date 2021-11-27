package com.brickBracker;

public class Tile {
    private int position;
    private SoftToy toy;
    public Tile(){ }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public SoftToy getToy() {
        return toy;
    }

    public void setToy(SoftToy toy) {
        this.toy = toy;
    }


}
