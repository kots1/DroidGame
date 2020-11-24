package com.droidgame.arena;

import com.droidgame.Collection.SkillsCollection;
import com.droidgame.model.Droid;

import java.util.ArrayList;

public class PlayerVSComputer extends mainArena{

    public PlayerVSComputer(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        super(firstTeam, secondTeam);
    }

    public void Fight() {
/*

        int round = 1;
        boolean isAttacked;
        int numAttacker=0;
        int numDefender=1;

        do {
            pause();
            printInfoAboutDroids(droids[numAttacker], droids[numDefender]);
            isAttacked= attack(round,droids[numAttacker],droids[numDefender]);
            if (!isAttacked){
                continue;
            }
            everyRoundChanges(droids[numAttacker], droids[numDefender]);

            if (!droids[numDefender].isAlive()) {
                break;
            }
            numAttacker=1-numAttacker;
            numDefender=1-numDefender;
            round++;
        } while (droids[numDefender].isAlive());
        System.out.println("The winner is " + droids[numAttacker].getName());
        gameOver();
*/

    }
}
