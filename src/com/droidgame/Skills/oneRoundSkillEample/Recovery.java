package com.droidgame.Skills.oneRoundSkillEample;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public class Recovery extends Skills {
    private int increaseHealthy = 60;

    @Override
    public void mainWork(Droid attacker, Droid defender) {
        attacker.increaseHealthy(increaseHealthy);
    }

    @Override
    public void startSkill(Droid attacker, Droid defender) {
        attacker.usedEnergy(usedEnergy);

    }

    @Override
    public void endSkill(Droid attacker, Droid defender) {

    }

    public Recovery() {
        usedEnergy = 800;
        countOfUse = 1;
    }

    @Override
    public String toString() {
        return "Recovery (" +
                "increase healthy= " + increaseHealthy +
                ", energy required= " + usedEnergy +
                '}';
    }
    @Override
    public String getName() {
        return "recovery";
    }
}
