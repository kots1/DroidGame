package com.droidgame.Skills;

import com.droidgame.model.Droid;

public abstract class Skills implements Comparable<Skills>{
    protected int usedEnergy;
    protected int countOfUse;

    public boolean isCanUsed(Droid attacker) {
        return attacker.getEnergy() >= usedEnergy;
    }

    public abstract void mainWork(Droid attacker, Droid defender);

    public abstract void startSkill(Droid attacker, Droid defender);

    public abstract void endSkill(Droid attacker, Droid defender);

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
