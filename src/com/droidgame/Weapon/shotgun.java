package com.droidgame.Weapon;

import com.droidgame.model.Droid;

public class shotgun implements WeaponInterface {
    private final int increaseAttack = 20;
    private final int decreasePrecision = 5;
    @Override
    public String toString() {
        return "shotgun (increase attack = "+increaseAttack+",decrease precision = "+decreasePrecision+" %) ";
    }

    @Override
    public void additionalFeatures(Droid droid) {
        droid.increaseAttack(increaseAttack);
        droid.increasePrecision(-decreasePrecision);
    }
}
