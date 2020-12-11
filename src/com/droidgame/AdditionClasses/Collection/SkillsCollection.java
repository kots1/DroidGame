package com.droidgame.AdditionClasses.Collection;

import com.droidgame.Skills.SingleSkill.periodSkillExamples.damageEveryRound;
import com.droidgame.Skills.SingleSkill.oneRoundSkillEample.AttackFreeze;
import com.droidgame.Skills.SingleSkill.oneRoundSkillEample.DefenceFreeze;
import com.droidgame.Skills.SingleSkill.periodSkillExamples.AttackBoost;
import com.droidgame.Skills.Skills;
import com.droidgame.Skills.SingleSkill.periodSkillExamples.DefenceBoost;
import com.droidgame.Skills.TeamSkill.AttackTeamSkill.ComboAttack;
import com.droidgame.Skills.TeamSkill.AttackTeamSkill.TeamAttackFreeze;
import com.droidgame.Skills.TeamSkill.AttackTeamSkill.TeamDamageEveryRound;
import com.droidgame.Skills.TeamSkill.DefenceTeamSkill.TeamAttackBoost;
import com.droidgame.Skills.TeamSkill.DefenceTeamSkill.TeamDefenceBoost;
import com.droidgame.model.Droid;

import java.util.*;

public class SkillsCollection {
    private ArrayList<Skills> singleSkills;
    private ArrayList<Skills> attackTeamSkills;
    private ArrayList<Skills> defenceTeamSkills;


    public SkillsCollection() {


        initializationSingleSkill();
        initializationAttackTeamSkills();
        initializationDefenceTeamSkills();
    }

    private void initializationDefenceTeamSkills() {
        defenceTeamSkills = new ArrayList<>();
        defenceTeamSkills.add(new TeamAttackBoost());
        defenceTeamSkills.add(new TeamDefenceBoost());
    }

    private void initializationAttackTeamSkills() {
        attackTeamSkills = new ArrayList<>();
        attackTeamSkills.add(new ComboAttack());
        attackTeamSkills.add(new TeamAttackFreeze());
        attackTeamSkills.add(new TeamDamageEveryRound());

    }

    private void initializationSingleSkill(){
        singleSkills = new ArrayList<>();
        singleSkills.add(new AttackBoost());
        singleSkills.add(new DefenceBoost());
        singleSkills.add(new damageEveryRound());
        singleSkills.add(new DefenceFreeze());
        singleSkills.add(new AttackFreeze());
    }

    public void printArray(ArrayList<Skills> team) {
        System.out.println("Skills:");
        int num = 1;
        for (Skills skill : team) {
            System.out.println((num++) + ") " + skill);
        }

    }

    public Skills chooseSkills(ArrayList<Skills> team) {
        System.out.print("Choose skills: ");
        int choice = new Scanner(System.in).nextInt();
        return team.get(choice-1);
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

}
