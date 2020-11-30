package com.droidgame.Skills.SingleSkill.oneRoundSkillEample;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class Recovery extends SingleSkill {
    private int increaseHealthy = 80;

    @Override
    public void mainWork() {
        attacker.increaseHealthy(increaseHealthy);
    }

    @Override
    public void startSkill() {
        attacker.usedEnergy(usedEnergy);

    }

    @Override
    public void endSkill() {

    }

    public Recovery() {
        usedEnergy = 1000;
        countOfUse = 1;
    }

    @Override
    public String toString() {
        return "Recovery (" +
                "energy required= " + usedEnergy +
                ", increase healthy= " + increaseHealthy +
                ')';
    }
    @Override
    public String getName() {
        return "Single recovery";
    }
}
