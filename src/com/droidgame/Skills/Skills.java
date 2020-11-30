package com.droidgame.Skills;

import com.droidgame.model.Droid;

public abstract class Skills implements Comparable<Skills>{
    protected int usedEnergy;
    protected int countOfUse;

    public boolean isCanUsed(Droid attacker) {
        return attacker.getEnergy() >= usedEnergy;
    }

    public abstract void mainWork();

    public abstract void startSkill();

    public abstract void endSkill();

    public int getCountOfUse() {
        return countOfUse;
    }

    @Override
    public int compareTo(Skills o) {
        return Integer.compare(usedEnergy,o.getUsedEnergy());
    }

    public abstract String getName();

    public int getUsedEnergy() {
        return usedEnergy;
    }
}
