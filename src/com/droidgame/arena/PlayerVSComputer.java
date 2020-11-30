package com.droidgame.arena;

import com.droidgame.model.Droid;

import java.util.ArrayList;

public class PlayerVSComputer extends templateArena {

    public PlayerVSComputer(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        super(firstTeam, secondTeam);
    }

    @Override
    public void Fight() {
        int round=1;
        do {
            pause();
            printInfoAboutDroids(firstTeam,secondTeam);
            attack(round++,chooseDroidWhichAttack(firstTeam),chooseDroidWhichIsAttacked(secondTeam),firstTeam,secondTeam);
            if(isEnd()){
                break;
            }
            computerAttack(round++,secondTeam,firstTeam);
            everyRoundChanges();
        }while (!isEnd());

    }


}
