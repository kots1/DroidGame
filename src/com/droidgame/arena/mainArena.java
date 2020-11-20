package com.droidgame.arena;

import com.droidgame.Collection.SkillsCollection;
import com.droidgame.Skills.SkillsInterface;
import com.droidgame.model.Droid;

import java.util.Random;
import java.util.Scanner;


public class mainArena {
    private Droid firstDroid;
    private Droid secondDroid;

    public mainArena(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }
    public void Fight()
    {
        SkillsCollection skills =new SkillsCollection();
        Droid attacker =firstDroid;
        Droid defender = secondDroid;
        int round = 1;

        do {
            pause();
            printInfoAboutDroids(attacker, defender);
            int choice = chooseTypeOfAttack(attacker);
            if(choice==1){
                defaultAttack(round,attacker, defender);
                 }
            else if(choice==2){
               boolean isCanUsed = useSkills(skills,attacker, defender);
               if(!isCanUsed){
                   System.out.println("Skill did't use \nDo attack again");
                   continue;
               }
            }
            everyRoundChanges(attacker,defender);

            if(!defender.isAlive()) break;
            Droid tmp=attacker;
            attacker=defender;
            defender=tmp;
            round++;
        }while (defender.isAlive());
        System.out.println("The winner is "+ attacker.getName());
        firstDroid.resetData();
        secondDroid.resetData();
    }

    private boolean useSkills(SkillsCollection skills, Droid attacker, Droid defender) {
        skills.printArray();
        int choice=chooseSkills();
        SkillsInterface selectedSkill =skills.getSkill(choice-1);
        if(selectedSkill.isCanUsed(attacker)){
            selectedSkill.mainWork(attacker,defender);
            return true;
        }
        return false;
    }

    private int chooseSkills() {
        System.out.print("Choose skills: ");
        return new Scanner(System.in).nextInt();
    }

    private void defaultAttack(int round,Droid attacker,Droid defender){
        int numAttack;
        boolean isDodge;
        numAttack=attacker.doHit();
        isDodge=defender.getHit(numAttack);
        printInfoAboutAttack(round,attacker,defender,numAttack,isDodge);


    }
    private int chooseTypeOfAttack(Droid attacker){
        System.out.println(attacker.getName()+" attack");
        System.out.println("Choose type of your attack:");
        System.out.println("1) default ");
        System.out.println("2) use skill");
        return new Scanner(System.in).nextInt();
    }

    private void pause() {
        new Scanner(System.in).nextLine();
    }

    private void printInfoAboutDroids(Droid attacker, Droid defender){
        System.out.println("Info about droid");
        System.out.println(attacker.getName()+" (healthy = "+attacker.getHealthy()+ " energy = "+attacker.getEnergy()+")");
        System.out.println(defender.getName()+" (healthy = "+defender.getHealthy()+ " energy = "+defender.getEnergy()+")");

    }

    private void printInfoAboutAttack(int round, Droid attacker, Droid defender,int numAttack,boolean isDodge) {
        System.out.println("Round "+round );
        if(numAttack==0){
            System.out.println(attacker.getName()+" missed(");
        }
        else
            if (!isDodge){
                System.out.println(defender.getName()+" dodged the attack!");
                }
        else {
        System.out.println(attacker.getName()+" attacked " + defender.getName() + " remove "+numAttack +" health");
        }
        }

    private void everyRoundChanges(Droid firstDroid,Droid secondDroid){
        firstDroid.roundChange();
        secondDroid.roundChange();
    }

}
