package com.brickBracker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
    Random rand = new Random();
    private final ArrayList<Tile> carpet = new ArrayList<>();
    private final ArrayList<SoftToy> bucket = new ArrayList<>();
    private final ArrayList<Tile> tiles = new ArrayList<>();
    private final String[] list = new String[]{"first","second","third","fourth","fifth"};
    static ArrayList<SoftToy> toys = new ArrayList<>();
    private final String[] toy_names = new String[]{"Fluffy bear", "Remote car", "Legos", "Doll", "Mr. Potato Head",
            "Teddy bear", "Minions", "Mickey Mouse","GI Joe","Ninja Hattori","Doraemon","Spiderman",
            "Remote Control Helicopter","Kung Fu Panda","Shinchan","Stuffed Unicorn","Soft rabbit",
            "Stuffed big Tiger","Jumbo The Elephant","Smooth Shivansh"};
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    Player boy = new Player();
    public Game(){
        for(int i=0;i<20;i++){
            tiles.add(i,new Tile());
            SoftToy st =toys.get(i);
            String name = toy_names[i];
            st.setToy_name(name);
            tiles.get(i).setPosition(i+1);
            carpet.add(tiles.get(i));
        }
    }
    public void play() {
        System.out.println("Game is ready!");
        for(int i=0;i<5;i++){
            System.out.print("Hit enter for your "+list[i]+" hop.");
            scan.next();
            int x = boy.hop();
            boy.set_position(x);
            if(boy.get_position()==21){
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
            }
            for(int j=0;j<20;j++){
                if(boy.get_position()==carpet.get(j).getPosition() && boy.get_position()%2==0){
                    try {
                        SoftToy toy = carpet.get(j).getToy();
                        SoftToy cloned_toy = toy.clone();
                        bucket.add(cloned_toy);
                        System.out.println("You won a " + toy_names[j] + " soft toy.");
                    }catch(CloneNotSupportedException cnse){
                        System.out.println("Something is wrong, clone could not be made!");
                    }
                }
                else if(boy.get_position()==carpet.get(j).getPosition()){
                    System.out.println("Question answer round! Integer or String?");
                    boolean taken=false;
                    while(!taken){
                        String option = scan.next();
                        if (option.equals("integer")) {
                            taken=true;
                            if (question_integer()) {
                                try {
                                    SoftToy toy = carpet.get(j).getToy();
                                    SoftToy cloned_toy = toy.clone();
                                    bucket.add(cloned_toy);
                                    System.out.println("You won a " + toy_names[j] + " soft toy.");
                                } catch (CloneNotSupportedException cnse) {
                                    System.out.println("Something is wrong, clone could not be made!");
                                }
                            } else {
                                System.out.println("Incorrect answer");
                            }

                        } else if (option.equals("string")) {
                            taken=true;
                            if (question_string()) {
                                try {
                                    SoftToy toy = carpet.get(j).getToy();
                                    SoftToy cloned_toy = toy.clone();
                                    bucket.add(cloned_toy);
                                    System.out.println("You won a " + toy_names[j] + " soft toy.");
                                } catch (CloneNotSupportedException cnse) {
                                    System.out.println("Something is wrong, clone could not be made!");
                                }
                            } else {
                                System.out.println("Incorrect answer");
                            }
                        } else {
                            System.out.println("Wrong input! Please enter string or integer for the question answer round");
                        }
                    }
                }
            }
        }
        System.out.println("Game Over!");
        print_bucket();
    }

    private void print_bucket() throws ArrayIndexOutOfBoundsException{
        System.out.println("Soft toys won by you are:");
        try {
            for (SoftToy softToy : bucket) {
                System.out.println(softToy.getToy_name());
            }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println("Exception :"+aioobe);
        }
    }

    private String random_string(){
        String set = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        StringBuilder str = new StringBuilder(4);
        for(int i=0;i<4;i++){
            int index = (int)(set.length() * Math.random());
            str.append(set.charAt(index));
        }
        return str.toString();
    }

    private boolean question_integer() throws InputMismatchException{
        int num1=rand.nextInt(1000);
        int num2=rand.nextInt(1000);
        boolean done = false;
        do{
            System.out.println("Calculate the result of "+num1+" divided by "+num2);
            try{
                int quotient= scan.nextInt();
                done =true;
                Generic <Integer> obj = new Generic<>(num1, num2);
                int ans = obj.divide();
                return quotient == ans;
            }catch(InputMismatchException ime){
                scan.next();
                System.out.println("Input Mismatch exception. Please enter an integer.");
            }
        }while(!done);
        return false;
    }

    private boolean question_string(){
        String str1 = random_string();
        String str2 = random_string();
        System.out.println("Calculate the concatenation of strings "+str1+" and "+str2);
        String answer = scan.next();
        Generic <String> obj = new Generic<>(str1, str2);
        String ans = obj.join();
        return answer.equals(ans);
    }
}