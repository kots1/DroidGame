package com.droidgame.Weapon;

import com.droidgame.model.Droid;

public class shield implements WeaponInterface{
    private final int increaseDefence = 50;
    @Override
    public String toString() {
        return "shield (increase defence = "+increaseDefence+")";
    }

    @Override
    public void additionalFeatures(Droid droid) {
        droid.increaseDefence(increaseDefence);
    }

    @Override
    public String getName() {
        return "shield";
    }
}
