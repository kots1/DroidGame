package com.droidgame.arena;

import com.droidgame.AdditionClasses.Collection.SkillsCollection;
import com.droidgame.AdditionClasses.WorkWithSkill;
import com.droidgame.Skills.Skills;
import com.droidgame.model.Droid;
import com.droidgame.model.HealDroid;

import java.util.*;


public abstract class templateArena {
    protected ArrayList<Droid> firstTeam;
    protected ArrayList<Droid> secondTeam;

    protected WorkWithSkill skills;

    public templateArena(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
       this.firstTeam=firstTeam;
       this.secondTeam=secondTeam;
       skills = new WorkWithSkill();
    }


    abstract public void Fight();

    protected void attack(int round, Droid attacker, Droid defender,ArrayList<Droid> attackTeam,ArrayList<Droid> defenceTeam) {
       while (true){
        int choice = chooseTypeOfAttack(attacker);
        if (choice == 1) {
            int powerOfAttack= defaultAttack( attacker, defender,attackTeam);
            printInfoAboutAttack(round, attacker, defender,  powerOfAttack);
        } else if (choice == 2) {
            Skills useSkills = useSkills(attacker,defender,attackTeam,defenceTeam);
            if (useSkills==null) {
                System.out.println("Skill did't use (not enough energy)\nDo attack again");
                continue;
            }
            printInfoAboutUseSkill(useSkills,round,attacker);
        }
           break;
       }

    }

    public Skills useSkills(Droid attacker, Droid defender, ArrayList<Droid> attackTeam, ArrayList<Droid> defenderTeam) {
        SkillsCollection skillsCollection=new SkillsCollection();
        ArrayList<Skills> allSkill=skillsCollection.createSkillArray(attackTeam,defenderTeam);
        skillsCollection.printArray(allSkill);
        Skills selectedSkill = skillsCollection.chooseSkills(allSkill);
        if (selectedSkill.isCanUsed(attacker)) {
            skills.addSkill(selectedSkill,attacker,defender,attackTeam,defenderTeam);
            return selectedSkill;
        }
        return null;
    }
    protected int defaultAttack( Droid attacker, Droid defender,ArrayList<Droid> attackTeam) {
        int powerOfAttack;
        int healthDecrease;
        if(attacker instanceof HealDroid){
            HealDroid healDroid =(HealDroid)attacker;
            powerOfAttack = healDroid.doHit(attackTeam);
        }else {
        powerOfAttack = attacker.doHit();
        }
        healthDecrease = defender.getHit(powerOfAttack);
       return healthDecrease;

    }

    protected int chooseTypeOfAttack(Droid attacker) {
        System.out.println(attacker.getName() + " attack");
        System.out.println("Choose type of your attack:");
        System.out.println("1) default ");
        System.out.println("2) use skill");
        while (true){
            int choice =new Scanner(System.in).nextInt();
            if(choice>0&&choice<=2){
                return choice;
            }
        }
    }

    protected void pause() {
        new Scanner(System.in).nextLine();
    }

    protected void printInfoAboutDroids() {
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

    protected void printInfoAboutAttack(int round, Droid attacker, Droid defender, int powerOfAttack) {
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Round " + round);
        if (powerOfAttack == 0) {
            System.out.println(attacker.getName() + " missed or opponent dodge the attack!");
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
            Skills useSkill=useRandomSkill(attacker,attackTeam,defenceTeam);
             if(useSkill!=null){
                 printInfoAboutUseSkill(useSkill,round,attacker);
                 return;
             }
        }
        Droid defender=randomDroid(defenceTeam);
        int powerOfAttack= defaultAttack(attacker,defender,attackTeam);
        printInfoAboutAttack(round, attacker, defender, powerOfAttack );
    }

    private void printInfoAboutUseSkill(Skills randomSkill,int round,Droid attacker) {
        System.out.println("Round "+round);
        System.out.println("\n"+randomSkill.getName() +" use by "+attacker.getName());
    }


    private Skills useRandomSkill(Droid attacker,ArrayList<Droid> attackTeam,ArrayList<Droid> defenceTeam){
        SkillsCollection skillsCollection = new SkillsCollection();
        ArrayList<Skills> skillArray=skillsCollection.createSkillArray( attackTeam,  defenceTeam);
        int numOfSkill =  skills.numOfSkillWhichCanUse(attacker.getEnergy(),skillArray);
        if(numOfSkill !=0){
            Skills randomSkill = skills.randomSkillFromBorder(numOfSkill,skillArray);
            skills.addSkill(randomSkill,attacker,randomDroid(defenceTeam),attackTeam,defenceTeam);
            return randomSkill;
        }
        return null;
    }
    protected Droid chooseDroidFromTeam(ArrayList<Droid> team) {
        if(team.size()==1){
            return team.get(0);
        }
        while (true){
        int choice = new Scanner(System.in).nextInt();
            if(choice>0&&choice<=team.size()){
                return team.get(choice-1);
            }
        }
    }
    protected void printWinner(){
        if(firstTeam.isEmpty()){
            System.out.println("The winner is First team!");
        }else {
            System.out.println("The winner is Second team!");
        }
    }

    protected boolean isEnd(){
        return firstTeam.isEmpty() || secondTeam.isEmpty();
    }
}
