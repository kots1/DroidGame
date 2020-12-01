package com.droidgame.Skills.TeamSkill.DefenceTeamSkill;

import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

public class TeamDefenceBoost extends TeamSkill {
    private int teamDefenceBoost = 1000;
    @Override
    public void mainWork() {

    }

    @Override
    public void startSkill() {
        usedDroid.usedEnergy(usedEnergy);
        for (Droid droid: defenceTeam){
            droid.increaseDefence(teamDefenceBoost);
        }
    }
    public TeamDefenceBoost() {
        usedEnergy = 1800;
        countOfUse = 5;
    }

    @Override
    public void endSkill() {
        for (Droid droid: defenceTeam){
            droid.increaseDefence(-teamDefenceBoost);
        }
    }

    @Override
    public String toString() {
        return "Team Defence Boost(" +
                "energy required= " + usedEnergy +
                ", attack boost=" + teamDefenceBoost +
                ')';
    }

    @Override
    public String getName() {
        return "Team defence boost ";
    }
}
