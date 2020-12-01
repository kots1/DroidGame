package com.droidgame.Skills;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

import java.util.ArrayList;

public class CurrentUsedSkill {
    private Skills useSkill;
    private int count;

    public void setTeamSkill(TeamSkill useSkill, Droid attacker , ArrayList<Droid>attackTeam, ArrayList<Droid>defenceTeam) {
        this.useSkill = useSkill;
        count = useSkill.getCountOfUse();
        useSkill.SetDroids(attacker,attackTeam,defenceTeam);
        useSkill.startSkill();
    }
    public void setSingleSkill(SingleSkill useSkill,Droid attacker, Droid defender){
        this.useSkill = useSkill;
        count = useSkill.getCountOfUse();
        useSkill.SetDroids(attacker,defender);
        useSkill.startSkill();
    }
    public void end(){
        useSkill.endSkill();
    }
    public boolean use() {
        if (count == 0) {
            useSkill.endSkill();
            return false;
        }
        count--;
        useSkill.mainWork();
        return true;
    }
}
