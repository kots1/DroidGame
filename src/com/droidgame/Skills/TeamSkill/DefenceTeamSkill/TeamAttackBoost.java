package com.droidgame.Skills.TeamSkill.DefenceTeamSkill;

import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

public class TeamAttackBoost extends TeamSkill {
    private int teamAttackBoost = 1000;
    @Override
    public void mainWork() {

    }

    @Override
    public void startSkill() {
        usedDroid.usedEnergy(usedEnergy);
        for (Droid droid: defenceTeam){
            droid.increaseAttack(teamAttackBoost);
        }
    }
    public TeamAttackBoost() {
        usedEnergy = 1800;
        countOfUse = 5;
    }

    @Override
    public void endSkill() {
        for (Droid droid: defenceTeam){
            droid.increaseAttack(-teamAttackBoost);
        }
    }

    @Override
    public String toString() {
        return "Team Attack Boost(" +
                "energy required= " + usedEnergy +
                ", attack boost=" + teamAttackBoost +
                ')';
    }

    @Override
    public String getName() {
        return "Team attack boost ";
    }
}
