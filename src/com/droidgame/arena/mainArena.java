package com.droidgame.arena;

import com.droidgame.model.Droid;

import java.util.Random;
import java.util.Scanner;


public class mainArena {
    private Droid firstDroid;
    private Droid secondDroid;

    public mainArena(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }
    public void Fight()
    {
        Droid attacker =firstDroid;
        Droid defender = secondDroid;
        int round = 1;
        int numAttack;
        boolean isDodge;
        do {
            pause();
            numAttack=attacker.doHit();
            isDodge=defender.getHit(numAttack);
            printInfo(round++,attacker,defender,numAttack,isDodge);
            everyRoundChanges(attacker,defender);
            if(!defender.isAlive()) break;
            Droid tmp=attacker;
            attacker=defender;
            defender=tmp;
        }while (defender.isAlive());
        System.out.println("The winner is "+ attacker.getName());
        firstDroid.resetData();
        secondDroid.resetData();
    }

    private void pause() {
        new Scanner(System.in).nextLine();
    }


    private void printInfo(int round, Droid attacker, Droid defender,int numAttack,boolean isDodge) {
        System.out.println("Round "+round );
        if(numAttack==0){
            System.out.println(attacker.getName()+" missed(");
        }
        else
            if (!isDodge){
                System.out.println(defender.getName()+" dodged the attack!");
                }
        else {
        System.out.println(attacker.getName()+" attacked " + defender.getName() + " remove "+numAttack +" health");
        }
        System.out.println("Info after round");
        System.out.println(attacker.getName()+" (healthy = "+attacker.getHealthy()+ " energy = "+attacker.getEnergy()+")");
        System.out.println(defender.getName()+" (healthy = "+defender.getHealthy()+ " energy = "+defender.getEnergy()+")");
    }

    private void everyRoundChanges(Droid firstDroid,Droid secondDroid){
        firstDroid.roundChange();
        secondDroid.roundChange();
    }

}
