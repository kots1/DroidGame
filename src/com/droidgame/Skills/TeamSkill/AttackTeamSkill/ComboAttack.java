package com.droidgame.Skills.TeamSkill.AttackTeamSkill;

import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

public class ComboAttack extends TeamSkill {
    private int damage = 40;
    @Override
    public void mainWork() {
        for (Droid droid:attackTeam){
            droid.increaseHealthy(-damage);
        }
    }

    @Override
    public void startSkill() {
        usedDroid.usedEnergy(usedEnergy);
    }

    public ComboAttack() {
        usedEnergy=1500;
        countOfUse=1;
    }

    @Override
    public void endSkill() {

    }

    @Override
    public String toString() {
            return "Combo attack (" +
                " energy required= " + usedEnergy +
                ", damage to every droid = " + damage +
                '}';
    }
    @Override
    public String getName() {
        return "Combo attack";
    }
}
