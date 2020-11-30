package com.droidgame.Skills.SingleSkill.oneRoundSkillEample;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class DefenceFreeze extends SingleSkill {
    private int round=3;


    public DefenceFreeze() {
        usedEnergy=1400;
        countOfUse =1;
    }

    @Override
    public String toString() {
        return "Defence freeze( " +
                "energy required = " + usedEnergy +
                ", set defence freeze on " + round +
                " rounds)";
    }

    @Override
    public void mainWork() {

    }

    @Override
    public void startSkill() {
        attacker.usedEnergy(usedEnergy);
        attacker.setFreezeDefence(round);
    }

    @Override
    public void endSkill() {

    }
    @Override
    public String getName() {
        return "Defence freeze";
    }
}
