package com.droidgame.Skills.SingleSkill.periodSkillExamples;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class AttackBoost extends SingleSkill {
    private int increaseAttack = 1000;


    public AttackBoost() {
        usedEnergy = 1000;
        countOfUse = 5;
    }

    @Override
    public void mainWork() {
    }

    @Override
    public void startSkill() {
        attacker.increaseAttack(increaseAttack);
        attacker.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill() {
        attacker.increaseAttack(-increaseAttack);
    }

    @Override
    public String toString() {
        return "Attack boost (" +
                "energy required= " + usedEnergy +
                ", increase attack= " + increaseAttack +
                " by " + countOfUse + " rounds, "+
                ')';
    }
    @Override
    public String getName() {
        return "Attack boost";
    }
}
