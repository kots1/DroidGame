package com.droidgame.Skills;

import com.droidgame.model.Droid;

public interface SkillsInterface {
    void mainWork(Droid attacker,Droid defender);
    boolean isCanUsed(Droid attacker);
}
