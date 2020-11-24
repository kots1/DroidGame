package com.droidgame.Skills;

import com.droidgame.model.Droid;

public class CurrentUsedSkill {
    private Skills useSkill;
    private int count;
    private Droid attacker;
    private Droid defender;

    public CurrentUsedSkill(Skills useSkill, Droid attacker, Droid defender) {
        this.useSkill = useSkill;
        this.attacker = attacker;
        this.defender = defender;
        count = useSkill.getCountOfUse();
        useSkill.startSkill(attacker, defender);
    }

    public boolean use() {
        if (count == 0) {
            useSkill.endSkill(attacker, defender);
            return false;
        }
        count--;
        useSkill.mainWork(attacker, defender);
        return true;
    }
}
