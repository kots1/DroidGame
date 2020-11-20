package com.droidgame.Skills;

import com.droidgame.model.Droid;

public class Recovery implements SkillsInterface{
    private int increaseHealthy = 50;
    private int usedEnergy = 500;

    @Override
    public void mainWork(Droid attacker, Droid defender) {
        attacker.usedEnergy(usedEnergy);
        attacker.increaseHealthy(increaseHealthy);
    }

    @Override
    public boolean isCanUsed(Droid attacker) {
        return attacker.getEnergy()>=usedEnergy;
    }

    @Override
    public String toString() {
        return "Recovery (" +
                "increase healthy= " + increaseHealthy +
                ", energy required= " + usedEnergy +
                '}';
    }
}
