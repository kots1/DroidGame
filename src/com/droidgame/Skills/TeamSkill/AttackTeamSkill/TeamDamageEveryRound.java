package com.droidgame.Skills.TeamSkill.AttackTeamSkill;

import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

public class TeamDamageEveryRound extends TeamSkill {
    private int damageEveryRound = 20;
    @Override
    public void mainWork() {
        for (Droid droid:attackTeam){
         droid.increaseHealthy(-damageEveryRound);
        }
    }

    public TeamDamageEveryRound() {
        this.countOfUse =5;
        this.usedEnergy=1700;
    }

    @Override
    public String toString() {
        return "Team Damage Every Round  ( " +
                "energy required = " + usedEnergy +
                ", decrease opponent's health = " + damageEveryRound +
                ", count round = " + countOfUse +
                ')';
    }

    @Override
    public void startSkill() {
        usedDroid.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill() {

    }
    @Override
    public String getName() {
        return "Damage every round";
    }
}
