package com.droidgame.Skills.TeamSkill;

import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

import java.util.ArrayList;

public abstract class TeamSkill extends Skills {
    protected ArrayList<Droid> attackTeam;
    protected ArrayList<Droid> defenceTeam;
    protected Droid usedDroid;
    public void SetDroids(Droid usedDroid,ArrayList<Droid> attackTeam,ArrayList<Droid> defenceTeam){
        this.usedDroid=usedDroid;
        this.attackTeam=attackTeam;
        this.defenceTeam=defenceTeam;
    }
}
