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
            printInfoAboutDroids(firstTeam,secondTeam);
            playerAttack(round++,"First",firstTeam,secondTeam);
            if(isEnd()){
                break;
            }
            printInfoAboutDroids(firstTeam,secondTeam);
            playerAttack(round++,"Second",secondTeam,firstTeam);
        }while (!isEnd());
        printWinner();
        GameOver();
    }
    private void playerAttack(int round,String teamNumber,ArrayList<Droid> attack,ArrayList<Droid> defence){
        pause();
        System.out.println(teamNumber+" player attack");
        System.out.println("Choose two droid (from your team and opponents)");
        attack(round,chooseDroidFromTeam(attack),chooseDroidFromTeam(defence),attack,defence);
        everyRoundChanges();
    }
}
