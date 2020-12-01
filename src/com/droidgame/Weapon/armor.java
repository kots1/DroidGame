package com.droidgame.Weapon;

import com.droidgame.model.Droid;

public class armor implements Weapon{
    private int decreaseOpportunityToDodge = 3;
    private int increaseDefence = 80;
    @Override
    public void additionalFeatures(Droid droid) {
        droid.increaseOpportunityToDodge(-decreaseOpportunityToDodge);
        droid.increaseDefence(increaseDefence);
    }

    @Override
    public String toString() {
        return "armor (" +
                "decrease opportunity to dodge = " + decreaseOpportunityToDodge +
                ", increase defence=" + increaseDefence +
                ')';
    }

    @Override
    public String getName() {
        return "armor";
    }
}
