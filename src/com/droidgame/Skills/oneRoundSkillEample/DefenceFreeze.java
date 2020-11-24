package com.droidgame.Skills.oneRoundSkillEample;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class DefenceFreeze extends Skills {
    private int round=2;
    @Override
    public void mainWork(Droid attacker, Droid defender) {

    }

    public DefenceFreeze() {
        usedEnergy=1500;
        countOfUse =1;
    }

    @Override
    public String toString() {
        return "defence freeze( " +
                "energy required = " + usedEnergy +
                ", set defence freeze on " + round +
                "rounds)";
    }

    @Override
    public void startSkill(Droid attacker, Droid defender) {
        attacker.usedEnergy(usedEnergy);
        attacker.setFreezeDefence(round);
    }

    @Override
    public void endSkill(Droid attacker, Droid defender) {

    }
    @Override
    public String getName() {
        return "defence freeze";
    }
}
