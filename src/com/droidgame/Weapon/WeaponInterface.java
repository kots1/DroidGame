package com.droidgame.Weapon;

import com.droidgame.model.Droid;

import java.io.Serializable;

public interface WeaponInterface extends Serializable {

    void additionalFeatures(Droid droid);
    String getName();
}
