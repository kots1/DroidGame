package com.droidgame.Skills.SingleSkill.periodSkillExamples;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class damageEveryRound extends SingleSkill {
    private int damageEveryRound = 20;
    @Override
    public void mainWork() {
        defender.increaseHealthy(-damageEveryRound);
    }

    public damageEveryRound() {
        this.countOfUse =6;
        this.usedEnergy=1100;
    }

    @Override
    public String toString() {
        return "Decrease health  ( " +
                "energy required = " + usedEnergy +
                ", decrease opponent's health = " + damageEveryRound +
                ", count round = " + countOfUse +
                ')';
    }

    @Override
    public void startSkill() {
        attacker.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill() {

    }
    @Override
    public String getName() {
        return "Damage every round";
    }
}
