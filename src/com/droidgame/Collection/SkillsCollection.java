package com.droidgame.Collection;

import com.droidgame.Skills.Recovery;
import com.droidgame.Skills.SkillsInterface;

import java.util.ArrayList;

public class SkillsCollection {
    private ArrayList<SkillsInterface> skills;

    public SkillsCollection(){
        skills=new ArrayList<>();
        skills.add(new Recovery());
    }
    public SkillsInterface getSkill(int index){
        return skills.get(index);
    }
    public void printArray(){
        System.out.println("Skills:");
        for (SkillsInterface skill:skills){
            System.out.println(skill);
        }
    }
}
