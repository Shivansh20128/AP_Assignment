package com.brickBracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Tile> carpet = new ArrayList<>();
    ArrayList<SoftToy> bucket = new ArrayList<>();
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    Player boy = new Player();
    public Game(){
        Tile tile1 = new Tile();
        SoftToy toy1 = new SoftToy();
        toy1.setToy_name("Fluffy bear");
        tile1.setPosition(1);
        tile1.setToy(toy1);

        Tile tile2 = new Tile();
        SoftToy toy2 = new SoftToy();
        toy2.setToy_name("Remote car");
        tile2.setPosition(2);
        tile2.setToy(toy2);

        Tile tile3 = new Tile();
        SoftToy toy3 = new SoftToy();
        toy3.setToy_name("Legos");
        tile3.setPosition(3);
        tile3.setToy(toy3);

        Tile tile4 = new Tile();
        SoftToy toy4 = new SoftToy();
        toy4.setToy_name("Doll");
        tile4.setPosition(4);
        tile4.setToy(toy4);

        Tile tile5 = new Tile();
        SoftToy toy5 = new SoftToy();
        toy5.setToy_name("Mr. Potato head");
        tile5.setPosition(5);
        tile5.setToy(toy5);

        Tile tile6 = new Tile();
        SoftToy toy6 = new SoftToy();
        toy6.setToy_name("Teddy bear");
        tile6.setPosition(6);
        tile6.setToy(toy6);

        Tile tile7 = new Tile();
        SoftToy toy7 = new SoftToy();
        toy7.setToy_name("Minions");
        tile7.setPosition(7);
        tile7.setToy(toy7);

        Tile tile8 = new Tile();
        SoftToy toy8 = new SoftToy();
        toy8.setToy_name("Mickey Mouse");
        tile8.setPosition(8);
        tile8.setToy(toy8);

        Tile tile9 = new Tile();
        SoftToy toy9 = new SoftToy();
        toy9.setToy_name("Ninja Hattori");
        tile9.setPosition(9);
        tile9.setToy(toy9);

        Tile tile10 = new Tile();
        SoftToy toy10 = new SoftToy();
        toy10.setToy_name("GI Joe");
        tile10.setPosition(10);
        tile10.setToy(toy10);

        Tile tile11 = new Tile();
        SoftToy toy11 = new SoftToy();
        toy11.setToy_name("Doraemon");
        tile11.setPosition(11);
        tile11.setToy(toy11);

        Tile tile12 = new Tile();
        SoftToy toy12 = new SoftToy();
        toy12.setToy_name("Water Guns");
        tile12.setPosition(12);
        tile12.setToy(toy12);

        Tile tile13 = new Tile();
        SoftToy toy13 = new SoftToy();
        toy13.setToy_name("Remote control Helicopter");
        tile13.setPosition(13);
        tile13.setToy(toy13);

        Tile tile14 = new Tile();
        SoftToy toy14 = new SoftToy();
        toy14.setToy_name("Kung Fu Panda");
        tile14.setPosition(14);
        tile14.setToy(toy14);

        Tile tile15 = new Tile();
        SoftToy toy15 = new SoftToy();
        toy15.setToy_name("Shinchan");
        tile15.setPosition(15);
        tile15.setToy(toy15);

        Tile tile16 = new Tile();
        SoftToy toy16 = new SoftToy();
        toy16.setToy_name("Stuffed Unicorn");
        tile16.setPosition(16);
        tile16.setToy(toy16);

        Tile tile17 = new Tile();
        SoftToy toy17 = new SoftToy();
        toy17.setToy_name("Soft Rabbit");
        tile17.setPosition(17);
        tile17.setToy(toy17);

        Tile tile18 = new Tile();
        SoftToy toy18 = new SoftToy();
        toy18.setToy_name("Stuffed big Tiger");
        tile18.setPosition(18);
        tile18.setToy(toy18);

        Tile tile19 = new Tile();
        SoftToy toy19 = new SoftToy();
        toy19.setToy_name("Jumbo The Elephant");
        tile19.setPosition(19);
        tile19.setToy(toy19);

        Tile tile20 = new Tile();
        SoftToy toy20 = new SoftToy();
        toy20.setToy_name("Smooth Shivansh");
        tile20.setPosition(20);
        tile20.setToy(toy20);

        carpet.add(tile1);
        carpet.add(tile2);
        carpet.add(tile3);
        carpet.add(tile4);
        carpet.add(tile5);
        carpet.add(tile6);
        carpet.add(tile7);
        carpet.add(tile8);
        carpet.add(tile9);
        carpet.add(tile10);
        carpet.add(tile11);
        carpet.add(tile12);
        carpet.add(tile13);
        carpet.add(tile14);
        carpet.add(tile15);
        carpet.add(tile16);
        carpet.add(tile17);
        carpet.add(tile18);
        carpet.add(tile19);
        carpet.add(tile20);

    }
    public void play(){
        System.out.println("Game is ready!");
        System.out.print("Hit enter for your first hop.");
        for(int i=0;i<5;i++) {
            String enter  = scan.next();
            int x = boy.hop();
            boy.set_position(x);
            for(int j=0;j<20;j++){
                if(boy.get_position()==carpet.get(j).getPosition() && boy.get_position()%2==0){
                    bucket.add(carpet.get(j).getToy());
                }
                else if(boy.get_position()==carpet.get(j).getPosition()){
                    System.out.println("Question answer round! Integers or Strings?");
                }
            }
        }
        for(int l=0;l< bucket.size();l++){
            System.out.println(bucket.get(l).getToy_name());
        }
    }
}


