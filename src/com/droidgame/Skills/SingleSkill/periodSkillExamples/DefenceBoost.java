package com.droidgame.Skills.SingleSkill.periodSkillExamples;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class DefenceBoost extends SingleSkill {
    private int increaseDefence = 2000;


    public DefenceBoost() {
        usedEnergy = 1000;
        countOfUse = 5;
    }

    @Override
    public void mainWork() {
    }

    @Override
    public void startSkill() {
        attacker.increaseAttack(increaseDefence);
        attacker.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill() {
        attacker.increaseAttack(-increaseDefence);
    }

    @Override
    public String toString() {
        return "Defence boost (" +
                "energy required = " + usedEnergy +
                ", increase attack= " + increaseDefence +
                " by " + countOfUse + " rounds, "+
                ')';
    }

    @Override
    public String getName() {
        return "Defence boost";
    }
}
