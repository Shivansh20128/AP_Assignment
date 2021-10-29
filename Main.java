package com.brickBracker;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in).useDelimiter("\n");
    static Floor _floor = new Floor();
    static Elevator_floor _ele_floor = new Elevator_floor();
    static Normal_snake_floor norm_floor = new Normal_snake_floor();
    static Cobra_snake_floor cobra_floor = new Cobra_snake_floor();
    static Ladder_floor ladder_floor = new Ladder_floor();

    public static void game(){

        Dice my_dice = new Dice(2);
        Player my_player = new Player();

        System.out.print("Enter the player name and hit enter: ");
        my_player.name = scan.next();
        System.out.println("The game setup is ready");
        while(true) {
            System.out.print("Hit enter to roll the dice");
            String s = scan.next();
            my_dice.roll();
            System.out.println("Dice gave: " + my_dice.getFaceValue());
            if (my_dice.getFaceValue() == 2) {
                System.out.println("Game cannot start until you get 1");
            }
            else if(my_dice.getFaceValue()==1){
                play_game(my_dice,my_player,my_dice.getFaceValue());
                break;
            }
        }
    }

    public static void play_game(Dice my_dice,Player _player,int n) {
        _player.setFloor_no(_player.getFloor_no()+n);
        System.out.println("Player position Floor- " + _player.getFloor_no());
        switch (_player.getFloor_no()) {
            case 0, 1, 3, 4, 6, 7, 9, 10, 12, 13 -> {
                _floor.normal(_player,_floor);
            }
            case 2 -> {
                _ele_floor.elevator(_player,_ele_floor);
                _ele_floor.normal(_player,_floor);
            }
            case 5 -> {
                norm_floor.normal_snake(_player,norm_floor);
                norm_floor.normal(_player,_floor);
            }
            case 8 -> {
                ladder_floor.ladder(_player,ladder_floor);
                ladder_floor.normal(_player,_floor);
            }
            case 11 -> {
                cobra_floor.cobra_floor(_player,cobra_floor);
                cobra_floor.normal(_player,_floor);
            }
        }
        if(_player.getFloor_no()!=13) {
            System.out.print("Hit enter to roll the dice");
            String s = scan.next();
            boolean condition = true;
            while (condition) {
                my_dice.roll();
                System.out.println("Dice gave: " + my_dice.getFaceValue());
                if (my_dice.getFaceValue() == 2 && _player.getFloor_no() == 12) {
                    System.out.println("Player cannot move");
                    System.out.print("Hit enter to roll the dice");
                    String s0 = scan.next();
                } else {
                    play_game(my_dice, _player, my_dice.getFaceValue());
                    condition=false;
                }
            }
        }
        else{
            System.out.println("---Game Over---");
            System.out.println(_player.name+" accumulated "+_player.getScore()+ " points");
        }
    }
    public static void main(String[] args){
        game();
    }
}
