package com.droidgame.Weapon;

import com.droidgame.model.Droid;

public class shotgun implements Weapon {
    private final int increaseAttack = 40;
    private final int decreasePrecision = 5;

    @Override
    public String toString() {
        return "shotgun (increase attack = " + increaseAttack + ",decrease precision = " + decreasePrecision + " %) ";
    }

    @Override
    public void additionalFeatures(Droid droid) {
        droid.increaseAttack(increaseAttack);
        droid.increasePrecision(-decreasePrecision);
    }

    @Override
    public String getName() {
        return "shotgun";
    }
}
