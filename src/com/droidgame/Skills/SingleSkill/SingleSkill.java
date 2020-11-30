package com.droidgame.Skills.SingleSkill;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

public abstract class SingleSkill extends Skills {
    protected Droid attacker;
    protected Droid defender;

    public void SetDroids(Droid attacker,Droid defender){
        this.attacker=attacker;
        this.defender=defender;
    }
}
