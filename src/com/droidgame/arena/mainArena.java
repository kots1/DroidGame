package com.droidgame.arena;

import com.droidgame.model.Droid;

import java.util.Random;

public class mainArena {
    private Droid firstDroid;
    private Droid secondDroid;

    public mainArena(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }
    public void Fight()
    {
        int round =1;
        do{
            attack(round,firstDroid,secondDroid);
            if(!secondDroid.isAlive()){
                break;
            }
            attack(++round,secondDroid,firstDroid);
        }while (firstDroid.isAlive());
        //System.out.println("The winner is "+attacker.getName());
    }

    private void PrintInfo(int round,Droid attacker) {
        System.out.println("---------------------");
        System.out.println("Round "+round);
        System.out.println(attacker.getName()+" do hit with damage "+attacker.doHit());
        System.out.println(firstDroid);
        System.out.println(secondDroid);
        System.out.println("---------------------");
    }
    private void attack(int round,Droid attacker, Droid defender){
        defender.getHit(attacker.doHit());
        PrintInfo(round,attacker);
    }
}
