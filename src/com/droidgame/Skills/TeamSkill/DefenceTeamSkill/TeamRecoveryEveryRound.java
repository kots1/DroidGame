package com.droidgame.Skills.TeamSkill.DefenceTeamSkill;

import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

public class TeamRecoveryEveryRound extends TeamSkill {
    private int everyRoundRecovery = 20;
    @Override
    public void mainWork() {
    for (Droid droid:defenceTeam){
        droid.increaseHealthy(everyRoundRecovery);
    }
    }

    public TeamRecoveryEveryRound() {
        usedEnergy=1500;
        countOfUse=5;
    }

    @Override
    public void startSkill() {
        usedDroid.usedEnergy(usedEnergy);
    }

    @Override
    public void endSkill() {

    }

    @Override
    public String getName() {
        return "Team health boost";
    }
}
