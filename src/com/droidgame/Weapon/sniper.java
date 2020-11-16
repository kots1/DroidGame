package com.droidgame.Weapon;

import com.droidgame.model.Droid;

public class sniper implements WeaponInterface{
    private final int increaseAttack = 10;
    private final int increasePrecision = 5;
    @Override
    public String toString() {
        return "sniper (increase attack = "+increaseAttack+",increase precision = "+increasePrecision+" %) ";
    }

    @Override
    public void additionalFeatures(Droid droid) {
        droid.increaseAttack(increaseAttack);
        droid.increasePrecision(increasePrecision);
    }
}
