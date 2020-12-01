package com.droidgame.AdditionClasses;

import com.droidgame.AdditionClasses.Collection.SkillsCollection;
import com.droidgame.Skills.CurrentUsedSkill;
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
        usedSkill = new ArrayList<>();;
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

    public boolean useSkills(Droid attacker, Droid defender, ArrayList<Droid> attackTeam, ArrayList<Droid> defenderTeam) {
        SkillsCollection skillsCollection=new SkillsCollection();
        ArrayList<Skills> allSkill=skillsCollection.createSkillArray(attackTeam,defenderTeam);
        skillsCollection.printArray(allSkill);
        Skills selectedSkill = skillsCollection.chooseSkills(allSkill);
        if (selectedSkill.isCanUsed(attacker)) {
            System.out.println(selectedSkill.getName() +" use by "+attacker.getName());
            addSkill(selectedSkill,attacker, defender,attackTeam,defenderTeam);
            return true;
        }
        return false;
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
    public void EndAllSkill(){
        for (CurrentUsedSkill skills:usedSkill){
            skills.end();
        }
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
