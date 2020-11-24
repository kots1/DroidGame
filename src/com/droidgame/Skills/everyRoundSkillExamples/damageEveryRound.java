package com.droidgame.Skills.everyRoundSkillExamples;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class damageEveryRound extends Skills {
    private int damageEveryRound = 10;
    @Override
    public void mainWork(Droid attacker, Droid defender) {
        defender.increaseHealthy(-damageEveryRound);
    }

    public damageEveryRound() {
        this.countOfUse =5;
        this.usedEnergy=1000;
    }

    @Override
    public String toString() {
        return "decrease health  ( " +
                "decrease opponent's health = " + damageEveryRound +
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
        return "damage every round";
    }
}
