package com.droidgame.Skills.periodSkillExamples;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class AttackBoost extends Skills {
    private int increaseAttack = 2000;


    public AttackBoost() {
        usedEnergy = 1000;
        countOfUse = 5;
    }

    @Override
    public void mainWork(Droid attacker, Droid defender) {
    }

    @Override
    public void startSkill(Droid attacker, Droid defender) {
        attacker.increaseAttack(increaseAttack);
        attacker.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill(Droid attacker, Droid defender) {
        attacker.increaseAttack(-increaseAttack);
    }

    @Override
    public String toString() {
        return "AttackBoost (" +
                "increase attack= " + increaseAttack +
                " by " + countOfUse + " rounds, energy required= " + usedEnergy +
                ')';
    }
    @Override
    public String getName() {
        return "attack boost";
    }
}
