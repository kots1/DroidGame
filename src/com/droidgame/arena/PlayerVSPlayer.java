package com.droidgame.arena;

import com.droidgame.model.Droid;

import java.util.ArrayList;

public class PlayerVSPlayer extends templateArena {
    public PlayerVSPlayer(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        super(firstTeam, secondTeam);
    }
    @Override
    public void Fight() {
        int round=1;
        do {
            pause();
            printInfoAboutDroids(firstTeam,secondTeam);
            System.out.println("First player attack");
             attack(round++,chooseDroidWhichAttack(firstTeam),chooseDroidWhichIsAttacked(secondTeam),firstTeam,secondTeam);
            if(isEnd()){
                break;
            }
            System.out.println("Second player attack");
            attack(round++,chooseDroidWhichAttack(secondTeam),chooseDroidWhichIsAttacked(firstTeam),secondTeam,firstTeam);
            everyRoundChanges();
        }while (!isEnd());

    }
}
