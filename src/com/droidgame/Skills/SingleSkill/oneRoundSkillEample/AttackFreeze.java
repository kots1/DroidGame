package com.droidgame.Skills.SingleSkill.oneRoundSkillEample;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class AttackFreeze extends SingleSkill {
    private int round=3;
    public AttackFreeze() {
        usedEnergy=1400;
        countOfUse =1;
    }

    @Override
    public void mainWork() {

    }

    @Override
    public String toString() {
        return "Attack freeze ( " +
                "energy required = " + usedEnergy +
                ", set attack freeze on " + round +
                " rounds)";
    }

    @Override
    public void startSkill() {
        attacker.usedEnergy(usedEnergy);
        defender.setFreezeAttack(round);
    }

    @Override
    public void endSkill() {

    }
    @Override
    public String getName() {
        return "Attack freeze";
    }
}
