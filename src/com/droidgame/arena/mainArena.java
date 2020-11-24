package com.droidgame.arena;

import com.droidgame.Collection.SkillsCollection;
import com.droidgame.model.Droid;

import java.util.*;


public class mainArena {
    protected Droid[] droids;
    protected ArrayList<Droid> firstTeam;
    protected ArrayList<Droid> secondTeam;

    protected SkillsCollection skills;

    public mainArena(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
       this.firstTeam=firstTeam;
       this.secondTeam=secondTeam;
       skills = new SkillsCollection();
    }


    public void Fight() {

        int round = 1;
        boolean isAttacked;
        int numAttacker=0;
        int numDefender=1;

        do {
            pause();
            //printInfoAboutDroids(droids[numAttacker], droids[numDefender]);
            isAttacked= attack(round,droids[numAttacker],droids[numDefender]);
            if (!isAttacked){
                continue;
            }
            everyRoundChanges();

            if (!droids[numDefender].isAlive()) {
                break;
            }
            numAttacker=1-numAttacker;
            numDefender=1-numDefender;
            round++;
        } while (droids[numDefender].isAlive());
        System.out.println("The winner is " + droids[numAttacker].getName());


    }

    protected boolean attack(int round, Droid attacker, Droid defender) {
        int choice = chooseTypeOfAttack(attacker);
        if (choice == 1) {
            defaultAttack(round, attacker, defender);
        } else if (choice == 2) {
            boolean isCanUsed = skills.useSkills(attacker, defender);
            if (!isCanUsed) {
                System.out.println("Skill did't use (not enough energy)\nDo attack again");
                return false;
            }
        }
        return true;
    }




    protected void defaultAttack(int round, Droid attacker, Droid defender) {
        int powerOfAttack;
        boolean isDodge;
        powerOfAttack = attacker.doHit();
        isDodge = defender.getHit(powerOfAttack);
        printInfoAboutAttack(round, attacker, defender, powerOfAttack, isDodge);

    }

    protected int chooseTypeOfAttack(Droid attacker) {
        System.out.println(attacker.getName() + " attack");
        System.out.println("Choose type of your attack:");
        System.out.println("1) default ");
        System.out.println("2) use skill");
        return new Scanner(System.in).nextInt();
    }

    protected void pause() {
        new Scanner(System.in).nextLine();
    }

    protected void printInfoAboutDroids(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        System.out.println("Info about droids");
        System.out.println("First Team:");
        printArray(firstTeam);
        System.out.println("Second Team:");
        printArray(secondTeam);
    }
    private void printArray(ArrayList<Droid> team){
        for (Droid droid:team){
            System.out.println(droid.getName() + " ( health = "+droid.getHealthy()+" energy = "+droid.getEnergy()+" )");
        }
    }

    protected void printInfoAboutAttack(int round, Droid attacker, Droid defender, int powerOfAttack, boolean isDodge) {
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Round " + round);
        if (powerOfAttack == 0) {
            System.out.println(attacker.getName() + " missed(");
        } else if (!isDodge) {
            System.out.println(defender.getName() + " dodged the attack!");
        } else {
            System.out.println(attacker.getName() + " attacked " + defender.getName() + " remove " + powerOfAttack + " health");
        }
    }
    protected Droid randomDroid(ArrayList<Droid> list){
        Random random=new Random();
        int numOfRandom=random.nextInt(list.size());
        return list.get(numOfRandom);
    }
    protected void everyRoundChanges() {
        skills.doEveryRoundSkill();
        isAlive(firstTeam);
        isAlive(secondTeam);
        roundChange(firstTeam);
        roundChange(secondTeam);
    }
    private void roundChange(List<Droid> list){
        for (Droid droid:list){
            droid.roundChange();
        }
    }
    private void isAlive(List<Droid> list){
        Iterator<Droid> iterator = list.iterator();
        while (iterator.hasNext()){
            Droid tmp =iterator.next();
            if(!tmp.isAlive()){
                iterator.remove();
            }
        }
    }
    protected boolean isEnd(){
        return firstTeam.isEmpty() || secondTeam.isEmpty();
    }
}
