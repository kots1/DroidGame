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
            printInfoAboutDroids();
            playerAttack(round++,"First",firstTeam,secondTeam);
            if(isEnd()){
                break;
            }
            printInfoAboutDroids();
            playerAttack(round++,"Second",secondTeam,firstTeam);
        }while (!isEnd());
        printWinner();
    }
    private void playerAttack(int round,String teamNumber,ArrayList<Droid> attack,ArrayList<Droid> defence){
        pause();
        System.out.println(teamNumber+" player attack");
        attack(round,chooseDroidFromTeam(attack),chooseDroidFromTeam(defence),attack,defence);
        everyRoundChanges();
    }
}
