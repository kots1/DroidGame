package com.droidgame.Skills.periodSkillExamples;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class DefenceBoost extends Skills {
    private int increaseDefence = 2000;


    public DefenceBoost() {
        usedEnergy = 1000;
        countOfUse = 5;
    }

    @Override
    public void mainWork(Droid attacker, Droid defender) {
    }

    @Override
    public void startSkill(Droid attacker, Droid defender) {
        attacker.increaseAttack(increaseDefence);
        attacker.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill(Droid attacker, Droid defender) {
        attacker.increaseAttack(-increaseDefence);
    }

    @Override
    public String toString() {
        return "DefenceBoost (" +
                "increase attack= " + increaseDefence +
                " by " + countOfUse + " rounds, energy required= " + usedEnergy +
                ')';
    }

    @Override
    public String getName() {
        return "defence boost";
    }
}
