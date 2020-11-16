package com.droidgame.Weapon;

import com.droidgame.model.Droid;

public class shoes implements WeaponInterface{
    private int increaseOpportunityToDodge = 5;
    @Override
    public String toString() {
        return "shoes (increase opportunity to dodge = "+increaseOpportunityToDodge+")";
    }

    @Override
    public void additionalFeatures(Droid droid) {
        droid.increaseOpportunityToDodge(increaseOpportunityToDodge);
    }
}
