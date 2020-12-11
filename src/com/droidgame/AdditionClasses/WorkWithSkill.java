package com.droidgame.AdditionClasses;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WorkWithSkill {

    private ArrayList<CurrentUsedSkill> usedSkill;

    public WorkWithSkill() {
        usedSkill = new ArrayList<>();
    }

    public int numOfSkillWhichCanUse(int energy, ArrayList<Skills> skillsArray){
        int numOfSkill=0;
        Collections.sort(skillsArray);
        ArrayList<Integer> requiredEnergy= inputRequiredEnergy( skillsArray);
        for (Integer needEnergy:requiredEnergy){
            if(needEnergy>energy){
                break;
            }
            numOfSkill++;
        }
        return numOfSkill;
    }
    private ArrayList<Integer> inputRequiredEnergy(ArrayList<Skills> skills){
        ArrayList<Integer> requiredEnergy=new ArrayList<>();
        for (Skills oneSkill:skills){
            requiredEnergy.add(oneSkill.getUsedEnergy());
        }
        return requiredEnergy;
    }

    public Skills randomSkillFromBorder(int border,ArrayList<Skills> skills){
        int randomSkill = new Random().nextInt(border);
        return skills.get(randomSkill);
    }



    public void addSkill(Skills skill, Droid attacker, Droid defender,  ArrayList<Droid> attackTeam,ArrayList<Droid>defenceTeam){
        CurrentUsedSkill newSkill=new CurrentUsedSkill();
        if(skill instanceof SingleSkill){
            newSkill.setSingleSkill((SingleSkill) skill,attacker,defender);
        }else {
            newSkill.setTeamSkill((TeamSkill)skill,attacker,defenceTeam,attackTeam);
        }
        usedSkill.add(newSkill);
    }

    public void doEveryRoundSkill() {
        if (usedSkill.isEmpty()) {
            return;
        }
        boolean isActive;
        for (int i = 0; i < usedSkill.size(); i++) {
            isActive = usedSkill.get(i).use();
            if (!isActive) {
                usedSkill.remove(i--);
            }
        }
    }
}
