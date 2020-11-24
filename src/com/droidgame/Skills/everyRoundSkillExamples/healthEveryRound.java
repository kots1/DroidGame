package com.droidgame.Skills.everyRoundSkillExamples;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class healthEveryRound extends Skills {
    private int healthEveryRound = 20;
    @Override
    public void mainWork(Droid attacker, Droid defender) {
        attacker.increaseHealthy(healthEveryRound);
    }

    public healthEveryRound() {
        this.countOfUse =6;
        this.usedEnergy=700;
    }

    @Override
    public String toString() {
        return "increase health  ( " +
                "health = " + healthEveryRound +
                ", energy required = " + usedEnergy +
                ", count round = " + countOfUse +
                ')';
    }

    @Override
    public void startSkill(Droid attacker, Droid defender) {
        attacker.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill(Droid attacker, Droid defender) {

    }
    @Override
    public String getName() {
        return "every round recovery";
    }
}
