package com.droidgame.model;

import com.droidgame.Weapon.Weapon;

import java.io.Serializable;
import java.util.Random;

public class Droid implements Serializable {
    private String name;
    private int maxHealth;
    private int healthy;
    private int damage;
    private int attack;
    private int defence;
    private int opportunityToDodge;
    private int precision;
    private int energy;
    private int maxEnergy;
    private int increaseEnergy;
    private int freezeAttack;
    private int freezeDefence;
    private Weapon weapon;

    public int getEnergy() {
        return energy;
    }

    public void increaseAttack(int attack) {
        this.attack += attack;
    }

    public void increaseDefence(int defence) {
        this.defence += defence;
    }

    public void increaseRoundEnergy(int increaseEnergy) {
        this.increaseEnergy += increaseEnergy;
    }

    public void increaseDamage(int damage) {
        this.damage += damage;
    }

    public void increaseOpportunityToDodge(int opportunityToDodge) {
        this.opportunityToDodge += opportunityToDodge;
    }

    public void increaseMaxEnergy(int maxEnergy) {
        this.maxEnergy += maxEnergy;
    }

    public void increasePrecision(int precision) {
        this.precision += precision;
        if (this.precision >= 100) {
            this.precision = 100;
        }
    }

    public void increaseHealthy(int healthy) {
        this.healthy += healthy;
        if (this.healthy >= maxHealth) {
            this.healthy = maxHealth;
        }
    }


    public void setFreezeAttack(int freezeAttack) {
        this.freezeAttack = freezeAttack;
    }

    public void setFreezeDefence(int freezeDefence) {
        this.freezeDefence = freezeDefence;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", healthy=" + healthy +
                ", energy=" + maxEnergy +
                ", damage = "+damage+
                ", attack = "+attack+
                ", defence = "+defence+
                ", weapon= " + weapon.getName();
    }

    public Droid(String name, int healthy, int damage, int attack, int defence, int precision, int maxEnergy, int increaseEnergy, int opportunityToDodge, Weapon weapon) {
        this.name = name;
        this.healthy = healthy;
        this.damage = damage;
        this.attack = attack;
        this.defence = defence;
        this.precision = precision;
        this.maxEnergy = maxEnergy;
        this.increaseEnergy = increaseEnergy;
        this.opportunityToDodge = opportunityToDodge;
        this.weapon = weapon;
        this.maxHealth = healthy;
        useWeapon();
    }

    public Droid(Droid copy){
        this.name = copy.name;
        this.healthy = copy.healthy;
        this.damage = copy.damage;
        this.attack = copy.attack;
        this.defence = copy.defence;
        this.precision = copy.precision;
        this.maxEnergy = copy.maxEnergy;
        this.increaseEnergy = copy.increaseEnergy;
        this.opportunityToDodge = copy.opportunityToDodge;
        this.weapon = copy.weapon;
        this.maxHealth = copy.healthy;
    }

    public void usedEnergy(int usedEnergy) {
        energy -= usedEnergy - increaseEnergy;
    }

    private void useWeapon() {
        weapon.additionalFeatures(this);
    }

    public boolean isAlive() {
        return healthy > 0;
    }

    public void roundChange() {
        energy += increaseEnergy;
        if (energy >= maxEnergy) {
            energy = maxEnergy;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealthy() {
        return Math.max(healthy, 0);
    }

    public int doHit() {
        if(freezeAttack!=0){
            freezeAttack--;
            return 0;
        }
        int random = new Random().nextInt(100);
        if (random == 1) {
            return damage + attack / 100 + 50;
        }
        if (random > precision) {
            return 0;
        }
        return damage + attack / 100;
    }

    public int getHit(int damage) {
        if(freezeDefence!=0){
            freezeDefence--;
            return 0;
        }
        if(damage == 0){
            return 0;
        }
        if (new Random().nextInt(100) < opportunityToDodge) {
            return 0;
        }
        int healthDecrease =(damage - defence / 100);
        healthy -= healthDecrease;
        return healthDecrease;

    }
}
