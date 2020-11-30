package com.droidgame.arena;

import com.droidgame.Collection.SkillsCollection;
import com.droidgame.Skills.SingleSkill.SingleSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;

import java.util.*;


public class templateArena {
    protected ArrayList<Droid> firstTeam;
    protected ArrayList<Droid> secondTeam;

    protected SkillsCollection skills;

    public templateArena(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
       this.firstTeam=firstTeam;
       this.secondTeam=secondTeam;
       skills = new SkillsCollection();
    }


    public void Fight() {

    }

    protected void attack(int round, Droid attacker, Droid defender,ArrayList<Droid> attackTeam,ArrayList<Droid> defenceTeam) {
       while (true){
        int choice = chooseTypeOfAttack(attacker);
        if (choice == 1) {
            defaultAttack(round, attacker, defender);
        } else if (choice == 2) {
            boolean isUsed = skills.useSkills(attacker,defender,attackTeam,defenceTeam);
            if (!isUsed) {
                System.out.println("Skill did't use (not enough energy)\nDo attack again");
                continue;
            }
        }
           break;
       }

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
        System.out.println("------------------");
        System.out.println("Info about droids");
        System.out.println("First Team:");
        printArray(firstTeam);
        System.out.println("Second Team:");
        printArray(secondTeam);
        System.out.println("------------------");

    }
    protected void printArray(ArrayList<Droid> team){
        int i=1;
        for (Droid droid:team){
            System.out.println((i++)+") "+droid.getName() + " ( health = "+droid.getHealthy()+" energy = "+droid.getEnergy()+" )");
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
    protected void swapTeam(){
        ArrayList<Droid> tmp =new ArrayList<>(firstTeam);
        firstTeam.clear();
        firstTeam.addAll(secondTeam);
        secondTeam.clear();
        secondTeam.addAll(tmp);
    }
    protected void computerAttack(int round,ArrayList<Droid> attackTeam,ArrayList<Droid> defenceTeam) {
        Random random = new Random();
        Droid attacker=randomDroid(attackTeam);
        int typeOfAttack =random.nextInt(3);
        if(typeOfAttack==0){
             ArrayList<Skills> skillArray=skills.createSkillArray( attackTeam,  defenceTeam);
            int numOfSkill =  skills.numOfSkillWhichCanUse(attacker.getEnergy(),skillArray);
            if(numOfSkill !=0){
                Skills randomSkill = skills.randomSkillFromBorder(numOfSkill,skillArray);
                skills.addSkill(randomSkill,attacker,randomDroid(defenceTeam),attackTeam,defenceTeam);
                System.out.println("\n"+randomSkill.getName() +" use by "+attacker.getName());
                return;
            }
        }
        defaultAttack(round,attacker,randomDroid(defenceTeam));
    }
    protected Droid chooseDroidWhichAttack(ArrayList<Droid> team) {
        if(team.size()==1){
            return team.get(0);
        }
        System.out.println("Choose droid for attack ");
        int choice = new Scanner(System.in).nextInt();
        return team.get(choice-1);
    }
    protected Droid chooseDroidWhichIsAttacked(ArrayList<Droid> team) {
        if(team.size()==1){
            return team.get(0);
        }
        System.out.println("Choose droid which is attacked ");
        int choice = new Scanner(System.in).nextInt();
        return team.get(choice-1);
    }
    protected boolean isEnd(){
        return firstTeam.isEmpty() || secondTeam.isEmpty();
    }
}