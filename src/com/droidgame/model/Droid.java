package com.droidgame.model;

import com.droidgame.Weapon.WeaponInterface;

import java.io.Serializable;
import java.util.Random;

public class Droid implements Serializable {
    private String name;
    private int maxHealth;
    private int  healthy;
    private int damage;
    private int attack;
    private int defence;
    private int opportunityToDodge;
    private int precision;
    private int energy;
    private int maxEnergy;
    private int increaseEnergy;
    private WeaponInterface weapon;

    public int getEnergy() {
        return energy;
    }

    public void increaseAttack(int attack) {
        this.attack += attack;
    }

    public void increaseDefence(int defence) {
        this.defence += defence;
    }

    public void increaseEnergy(int increaseEnergy) {
        this.increaseEnergy += increaseEnergy;
    }

    public void increaseOpportunityToDodge(int opportunityToDodge) {
        this.opportunityToDodge += opportunityToDodge;
    }

    public void increaseMaxEnergy(int maxEnergy){this.maxEnergy+=maxEnergy; }

    public void increasePrecision(int precision){
        this.precision+=precision;
        if(this.precision>=100){
            this.precision=100;
        }
    }
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", healthy=" + healthy +
                ", energy=" + maxEnergy +", weapon= " +weapon.getName();
    }

    public Droid(String name, int healthy, int damage, int attack, int defence, int precision, int maxEnergy, int increaseEnergy, int opportunityToDodge, WeaponInterface weapon) {
        this.name = name;
        this.healthy = healthy;
        this.damage = damage;
        this.attack = attack;
        this.defence = defence;
        this.precision = precision;
        this.maxEnergy =maxEnergy;
        this.increaseEnergy=increaseEnergy;
        this.opportunityToDodge=opportunityToDodge;
        this.weapon=weapon;
        this.maxHealth = healthy;
        useWeapon();
    }

    public void resetData(){
        healthy=maxHealth;
        energy=0;
    }

    private void useWeapon(){
        weapon.additionalFeatures(this);
    }

    public boolean isAlive(){
        return healthy>0;
    }

    public void roundChange(){
        energy+=increaseEnergy;
        if(energy>=maxEnergy){
            energy=maxEnergy;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthy() {
        return Math.max(healthy, 0);
    }

    public int doHit(){
        if(new Random().nextInt(100)>precision){
            return 0;
        }
        return damage+attack/100;
    }

    public boolean getHit(int damage) {
        if(new Random().nextInt(100)<opportunityToDodge){
            return false;
        }
        healthy -= (damage-defence/100);
        return true;
    }
}
