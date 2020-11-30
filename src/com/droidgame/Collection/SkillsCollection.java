package com.droidgame.Collection;

import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.SingleSkill.everyRoundSkillExamples.damageEveryRound;
import com.droidgame.Skills.SingleSkill.everyRoundSkillExamples.healthEveryRound;
import com.droidgame.Skills.SingleSkill.oneRoundSkillEample.AttackFreeze;
import com.droidgame.Skills.SingleSkill.oneRoundSkillEample.DefenceFreeze;
import com.droidgame.Skills.SingleSkill.periodSkillExamples.AttackBoost;
import com.droidgame.Skills.CurrentUsedSkill;
import com.droidgame.Skills.SingleSkill.oneRoundSkillEample.Recovery;
import com.droidgame.Skills.Skills;
import com.droidgame.Skills.SingleSkill.periodSkillExamples.DefenceBoost;
import com.droidgame.Skills.TeamSkill.AttackTeamSkill.ComboAttack;
import com.droidgame.Skills.TeamSkill.DefenceTeamSkill.TeamRecovery;
import com.droidgame.Skills.TeamSkill.TeamSkill;
import com.droidgame.model.Droid;

import java.util.*;

public class SkillsCollection {
    private ArrayList<Skills> singleSkills;
    private ArrayList<Skills> attackTeamSkills;
    private ArrayList<Skills> defenceTeamSkills;

    private ArrayList<CurrentUsedSkill> usedSkill;
    private ArrayList<Integer> requiredEnergy ;

    public SkillsCollection() {

        usedSkill = new ArrayList<>();
        initializationSingleSkill();
        initializationAttackTeamSkills();
        initializationDefenceTeamSkills();
    }

    private void initializationDefenceTeamSkills() {
        defenceTeamSkills = new ArrayList<>();
        defenceTeamSkills.add(new TeamRecovery());
    }

    private void initializationAttackTeamSkills() {
        attackTeamSkills = new ArrayList<>();
        attackTeamSkills.add(new ComboAttack());

    }

    private void initializationSingleSkill(){
        singleSkills = new ArrayList<>();
        singleSkills.add(new Recovery());
        singleSkills.add(new AttackBoost());
        singleSkills.add(new healthEveryRound());
        singleSkills.add(new DefenceBoost());
        singleSkills.add(new damageEveryRound());
        singleSkills.add(new DefenceFreeze());
        singleSkills.add(new AttackFreeze());
    }
    public int numOfSkillWhichCanUse(int energy,ArrayList<Skills> skillsArray){
        int numOfSkill=0;
        Collections.sort(skillsArray);
        inputRequiredEnergy( skillsArray);
        for (Integer needEnergy:requiredEnergy){
            if(needEnergy>energy){
                break;
            }
            numOfSkill++;
        }
        return numOfSkill;
    }
    private void inputRequiredEnergy(ArrayList<Skills> skills){
        requiredEnergy=new ArrayList<>();
        for (Skills oneSkill:skills){
            requiredEnergy.add(oneSkill.getUsedEnergy());
        }
    }

    public Skills randomSkillFromBorder(int border,ArrayList<Skills> skills){
        int randomSkill = new Random().nextInt(border);
        return skills.get(randomSkill);
    }

    public void printArray(ArrayList<Skills> team) {
        System.out.println("Skills:");
        int num = 1;
        for (Skills skill : team) {
            System.out.println((num++) + ") " + skill);
        }

    }

    private Skills chooseSkills(ArrayList<Skills> team) {
        System.out.print("Choose skills: ");
        int choice = new Scanner(System.in).nextInt();
        return team.get(choice-1);
    }

    public boolean useSkills(Droid attacker,Droid defender, ArrayList<Droid> attackTeam, ArrayList<Droid> defenderTeam) {
         ArrayList<Skills> allSkill=createSkillArray(attackTeam,defenderTeam);
        printArray(allSkill);
        Skills selectedSkill = chooseSkills(allSkill);
        if (selectedSkill.isCanUsed(attacker)) {
            System.out.println(selectedSkill.getName() +" use by "+attacker.getName());
            addSkill(selectedSkill,attacker, defender,attackTeam,defenderTeam);
            return true;
        }
        return false;
    }

    public ArrayList<Skills> createSkillArray(ArrayList<Droid> attackTeam, ArrayList<Droid> defenderTeam) {
        ArrayList<Skills> allSkill = new ArrayList<>(singleSkills);
        if(defenderTeam.size()!=1){
            allSkill.addAll(attackTeamSkills);
        }
        if(attackTeam.size()!=1){
            allSkill.addAll(defenceTeamSkills);
        }
        return allSkill;
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
