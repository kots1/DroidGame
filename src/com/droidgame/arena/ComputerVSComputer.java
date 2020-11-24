package com.droidgame.arena;

import com.droidgame.Collection.SkillsCollection;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ComputerVSComputer extends mainArena{
    public ComputerVSComputer(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        super(firstTeam, secondTeam);
    }

    @Override
    public void Fight() {
        int round=1;
        ArrayList<Droid> attackTeam=firstTeam;
        ArrayList<Droid> defenceTeam=secondTeam;
        do {
            pause();
            printInfoAboutDroids(firstTeam,secondTeam);

            computerAttack(round++,attackTeam,defenceTeam);
            everyRoundChanges();
            swapTeam();
        }while (!isEnd());
            /*do {
            pause();
            printInfoAboutDroids(droids[numAttacker], droids[numDefender]);
            isAttacked= attack(round,droids[numAttacker],droids[numDefender]);
            if (!isAttacked){
                continue;
            }
            everyRoundChanges(droids[numAttacker], droids[numDefender]);

            if (!droids[numDefender].isAlive()) {
                break;
            }
            numAttacker=1-numAttacker;
            numDefender=1-numDefender;
            round++;
        } while (droids[numDefender].isAlive());
        System.out.println("The winner is " + droids[numAttacker].getName());
        gameOver();*/
    }
    private void swapTeam(){
        ArrayList<Droid> tmp =new ArrayList<>(firstTeam);
        firstTeam.clear();
        firstTeam.addAll(secondTeam);
        secondTeam.clear();
        secondTeam.addAll(tmp);
    }
    private void computerAttack(int round,ArrayList<Droid> attackTeam,ArrayList<Droid> defenceTeam) {
        Random random = new Random();
        Droid attacker=randomDroid(attackTeam);
        int typeOfAttack =random.nextInt(3);
        if(typeOfAttack==0){
            int numOfSkill =  skills.numOfSkillWhichCanUse(attacker.getEnergy());
            if(numOfSkill !=0){
                Skills randomSkill = skills.randomSkillFromBorder(numOfSkill);
                skills.addSkill(randomSkill,attacker,randomDroid(defenceTeam));
                System.out.println("\n"+randomSkill.getName() +" use by "+attacker.getName());
                return;
            }
        }
        defaultAttack(round,attacker,randomDroid(defenceTeam));
    }



}
