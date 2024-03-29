package com.droidgame.Weapon;

import com.droidgame.model.Droid;

public class scepter implements Weapon {
    private final int increaseEnergy = 20;
    private final int increaseMaxEnergy = 500;

    @Override
    public String toString() {
        return "scepter (increase energy = " + increaseEnergy + " increase max energy = " + increaseMaxEnergy + ")";
    }

    @Override
    public void additionalFeatures(Droid droid) {
        droid.increaseRoundEnergy(increaseEnergy);
        droid.increaseMaxEnergy(increaseMaxEnergy);
    }

    @Override
    public String getName() {
        return "scepter";
    }
}
