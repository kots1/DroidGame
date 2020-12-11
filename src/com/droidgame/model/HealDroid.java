package com.droidgame.model;

import com.droidgame.Weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class HealDroid extends Droid{
    private int increaseHealth;
    private int countOfHeal=3;
    public HealDroid(String name, int healthy, int damage, int attack, int defence, int precision, int maxEnergy, int increaseEnergy, int opportunityToDodge, Weapon weapon,int increaseHealth) {
        super(name, healthy, damage, attack, defence, precision, maxEnergy, increaseEnergy, opportunityToDodge, weapon);
        this.increaseHealth=increaseHealth;
    }
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ",type = heal droid,"+
                "healthy=" + healthy +
                ", energy=" + maxEnergy +
                ", damage = "+damage+
                ", attack = "+attack+
                ", defence = "+defence+
                ", weapon= " + weapon.getName();
    }
    public HealDroid(Droid copy) {
        super(copy);
        HealDroid droid=(HealDroid)copy;
        this.increaseHealth=droid.increaseHealth;
    }
    public int doHit(ArrayList<Droid> droidList){
        if(countOfHeal==0){
        doHeal(droidList);
        countOfHeal=3;
        }
        countOfHeal--;
        return super.doHit();
    }
    public void doHeal(List<Droid> droidList){
        for(Droid droid:droidList){
            droid.increaseHealthy(increaseHealth);
        }
    }

}
