package com.droidgame.Skills.oneRoundSkillEample;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class AttackFreeze extends Skills {
    private int round=2;
    public AttackFreeze() {
        usedEnergy=1500;
        countOfUse =1;
    }

    @Override
    public void mainWork(Droid attacker, Droid defender) {

    }

    @Override
    public String toString() {
        return "attack freeze ( " +
                "energy required = " + usedEnergy +
                ", set attack freeze on " + round +
                "rounds)";
    }

    @Override
    public void startSkill(Droid attacker, Droid defender) {
        attacker.usedEnergy(usedEnergy);
        defender.setFreezeAttack(round);
    }

    @Override
    public void endSkill(Droid attacker, Droid defender) {

    }
    @Override
    public String getName() {
        return "attack freeze";
    }
}
