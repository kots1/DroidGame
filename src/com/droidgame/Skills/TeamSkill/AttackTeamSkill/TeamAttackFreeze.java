package com.droidgame.Skills.TeamSkill.AttackTeamSkill;

import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

public class TeamAttackFreeze extends TeamSkill {
    private int round=2;
    public TeamAttackFreeze() {
        usedEnergy=1400;
        countOfUse =1;
    }

    @Override
    public void mainWork() {

    }

    @Override
    public String toString() {
        return "Team Attack freeze ( " +
                "energy required = " + usedEnergy +
                ", set attack freeze on " + round +
                " rounds)";
    }

    @Override
    public void startSkill() {
        usedDroid.usedEnergy(usedEnergy);
        for (Droid droid: attackTeam){
             droid.setFreezeAttack(round);
        }
    }

    @Override
    public void endSkill() {

    }
    @Override
    public String getName() {
        return "Team attack freeze";
    }
}
