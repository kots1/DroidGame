package com.droidgame.Skills.TeamSkill.DefenceTeamSkill;

import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

public class TeamRecovery extends TeamSkill {
    private int increaseHealthy=40;
    @Override
    public void mainWork() {
        for (Droid droid: defenceTeam){
            droid.increaseHealthy(increaseHealthy);
        }
    }

    @Override
    public void startSkill() {
        usedDroid.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill() {

    }
    public TeamRecovery() {
        usedEnergy = 1800;
        countOfUse = 1;
    }

    @Override
    public String toString() {
        return "Team recovery (" +
                "energy required= " + usedEnergy +
                ", increase healthy= " + increaseHealthy +
                ')';
    }
    @Override
    public String getName() {
        return "Team recovery";
    }
}
