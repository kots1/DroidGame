package com.droidgame.Weapon;

import com.droidgame.model.Droid;

public class scepter  implements WeaponInterface{
    private final int increaseEnergy = 20;
    @Override
    public String toString() {
        return "scepter (increase energy = "+increaseEnergy+")";
    }

    @Override
    public void additionalFeatures(Droid droid) {
        droid.increaseEnergy(increaseEnergy);
    }
}
