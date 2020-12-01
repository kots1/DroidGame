package com.droidgame.Skills.SingleSkill.everyRoundSkillExamples;

import com.droidgame.Skills.SingleSkill.SingleSkill;


public class healthEveryRound extends SingleSkill {
    private int healthEveryRound = 20;
    @Override
    public void mainWork() {
        attacker.increaseHealthy(healthEveryRound);
    }

    public healthEveryRound() {
        this.countOfUse =6;
        this.usedEnergy=1100;
    }

    @Override
    public String toString() {
        return "Increase health  ( " +
                "energy required = " + usedEnergy +
                ", health = " + healthEveryRound +
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
        return "Every round recovery";
    }
}
