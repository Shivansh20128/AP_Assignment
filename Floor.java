package com.brickBracker;

public class Floor {

    public Floor(){}
    private int _floor_no;
    private Player _player;

    public void normal(Player p, Floor f){
        _player=p;
        _floor_no=p.getFloor_no();
        System.out.println(_player.name + " has reached an empty floor");
        _player.setScore(_player.getScore()+1);
        System.out.println("Total points: " + _player.getScore());
    }

    public void set_floor_no(int _floor_no) {
        this._floor_no = _floor_no;
    }
}
