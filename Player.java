package com.brickBracker;
import java.lang.Math;

public class Player {
    private int _position;
    public Player(){ }
    public int hop(){
        int random_num = (int) (1 + (100*Math.random())%21);
        System.out.println("You landed on tile "+ random_num);
        return random_num;
    }

    public int get_position() {
        return _position;
    }

    public void set_position(int _position) {
        this._position = _position;
    }

}
