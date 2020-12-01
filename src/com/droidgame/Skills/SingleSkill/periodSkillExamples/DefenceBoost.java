package com.droidgame.Skills.SingleSkill.periodSkillExamples;

import com.droidgame.Skills.SingleSkill.SingleSkill;

public class DefenceBoost extends SingleSkill {
    private int increaseDefence = 1000;


    public DefenceBoost() {
        usedEnergy = 1000;
        countOfUse = 5;
    }

    @Override
    public void mainWork() {
    }

    @Override
    public void startSkill() {
        attacker.increaseDefence(increaseDefence);
        attacker.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill() {
        attacker.increaseDefence(-increaseDefence);
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
