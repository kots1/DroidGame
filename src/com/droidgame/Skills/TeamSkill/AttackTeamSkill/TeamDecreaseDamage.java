package com.droidgame.Skills.TeamSkill.AttackTeamSkill;

import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

public class TeamDecreaseDamage extends TeamSkill {
    private int teamDegreaseDamage = 10;
    @Override
    public void mainWork() {

    }

    @Override
    public void startSkill() {
        usedDroid.usedEnergy(usedEnergy);
        for (Droid droid: defenceTeam){
            droid.increaseDamage(-teamDegreaseDamage);
        }
    }
    public TeamDecreaseDamage() {
        usedEnergy = 1800;
        countOfUse = 3;
    }

    @Override
    public void endSkill() {
        for (Droid droid: defenceTeam){
            droid.increaseDamage(teamDegreaseDamage);
        }
    }

    @Override
    public String toString() {
        return "Team Decrease Damage (" +
                "energy required= " + usedEnergy +
                ", decrease opponent's damage =" + teamDegreaseDamage +
                " on "+countOfUse+" rounds)";
    }

    @Override
    public String getName() {
        return "Team attack boost ";
    }
}
