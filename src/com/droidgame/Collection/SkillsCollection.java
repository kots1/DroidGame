package com.droidgame.Collection;

import com.droidgame.Skills.everyRoundSkillExamples.damageEveryRound;
import com.droidgame.Skills.everyRoundSkillExamples.healthEveryRound;
import com.droidgame.Skills.oneRoundSkillEample.AttackFreeze;
import com.droidgame.Skills.oneRoundSkillEample.DefenceFreeze;
import com.droidgame.Skills.periodSkillExamples.AttackBoost;
import com.droidgame.Skills.CurrentUsedSkill;
import com.droidgame.Skills.oneRoundSkillEample.Recovery;
import com.droidgame.Skills.Skills;
import com.droidgame.Skills.periodSkillExamples.DefenceBoost;
import com.droidgame.model.Droid;

import java.util.*;

public class SkillsCollection {
    private ArrayList<Skills> skills;
    private ArrayList<CurrentUsedSkill> usedSkill;
    private ArrayList<Integer> requiredEnergy ;

    public SkillsCollection() {
        skills = new ArrayList<>();
        usedSkill = new ArrayList<>();
        skills.add(new Recovery());
        skills.add(new AttackBoost());
        skills.add(new healthEveryRound());
        skills.add(new DefenceBoost());
        skills.add(new damageEveryRound());
        skills.add(new DefenceFreeze());
        skills.add(new AttackFreeze());
        Collections.sort(skills);
        inputRequiredEnergy();
    }
    public int numOfSkillWhichCanUse(int energy){
        int numOfSkill=0;
        for (Integer needEnergy:requiredEnergy){
            if(needEnergy>energy){
                break;
            }
            numOfSkill++;
        }
        return numOfSkill;
    }
    private void inputRequiredEnergy(){
        requiredEnergy=new ArrayList<>();
        for (Skills oneSkill:skills){
            requiredEnergy.add(oneSkill.getUsedEnergy());
        }
    }

    public Skills randomSkillFromBorder(int border){
        int randomSkill = new Random().nextInt(border);
        return skills.get(randomSkill);
    }
    public void printArray() {
        System.out.println("Skills:");
        int num = 1;
        for (Skills skill : skills) {
            System.out.println((num++) + ") " + skill);
        }
    }

    private Skills chooseSkills() {
        System.out.print("Choose skills: ");
        int choice = new Scanner(System.in).nextInt();
        return skills.get(choice-1);
    }

    public boolean useSkills(Droid attacker, Droid defender) {
        printArray();
        Skills selectedSkill = chooseSkills();
        if (selectedSkill.isCanUsed(attacker)) {
            System.out.println(selectedSkill.getName() +" use ");
            addSkill(selectedSkill,attacker, defender);
            return true;
        }
        return false;
    }
    public void addSkill(Skills skill,Droid attacker,Droid defender){
        usedSkill.add(new CurrentUsedSkill(skill, attacker, defender));
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
