package com.droidgame.arena;

import com.droidgame.model.Droid;

import java.util.ArrayList;

public class ComputerVSComputer extends templateArena {
    public ComputerVSComputer(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        super(firstTeam, secondTeam);
    }

    @Override
    public void Fight() {
        int round=1;
        ArrayList<Droid> attackTeam=firstTeam;
        ArrayList<Droid> defenceTeam=secondTeam;
        do {
            pause();
            printInfoAboutDroids();

            computerAttack(round++,attackTeam,defenceTeam);
            everyRoundChanges();
            swapTeam();
        }while (!isEnd());
        printWinner();
    }




}
