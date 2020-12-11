package com.droidgame.AdditionClasses.Collection;

import com.droidgame.AdditionClasses.GameScanner;
import com.droidgame.Weapon.Weapon;
import com.droidgame.model.Droid;
import com.droidgame.model.HealDroid;

import java.util.ArrayList;

public class DroidCollection {
    private ArrayList<Droid> droids;

    public DroidCollection(ArrayList<Droid> arrayList) {
        droids = arrayList;
    }

    public void createDroid() {
        GameScanner scan = new GameScanner();
        String name = scan.inputName();
        System.out.print("Input healthy: ");
        int healthy = scan.inputData();
        System.out.print("Input damage: ");
        int damage = scan.inputData();
        System.out.print("Input attack: ");
        int attack = scan.inputData();
        System.out.print("Input defence: ");
        int defence = scan.inputData();
        System.out.print("Input precision (0-100%): ");
        int precision = scan.inputPercent();
        System.out.print("Input max energy: ");
        int maxEnergy = scan.inputData();
        System.out.print("Input each round of energy increase: ");
        int increaseEnergy = scan.inputData();
        System.out.print("Input opportunity to dodge (0-100%): ");
        int opportunityToDodge = scan.inputPercent();
        Weapon weapon = scan.chooseWeapon(new WeaponCollection());
        int choice = scan.ChooseTypeOfDroid();
        if(choice==1){
        droids.add(new Droid(name, healthy, damage, attack, defence, precision, maxEnergy, increaseEnergy, opportunityToDodge, weapon));
        } else {
            System.out.print("Input increase health: ");
            int increaseHealth= scan.inputData();
            droids.add(new HealDroid(name, healthy, damage, attack, defence, precision, maxEnergy, increaseEnergy, opportunityToDodge, weapon,increaseHealth));
        }
    }

    public ArrayList<Droid> getArray() {
        return droids;
    }
    public int getCountOfDroids(){
        return droids.size();
    }
    public void printDroids() {
        if (droids.isEmpty()) {
            System.out.println("Array is empty");
            return;
        }
        int i = 1;
        System.out.println("List");
        for (Droid droid : droids) {
            System.out.println((i++) + ") " + droid);
        }
    }
    public void setArray(ArrayList<Droid> array){
        droids.clear();
        droids.addAll(array);
    }
    public void deleteDroid(int index) {
        droids.remove(index);
    }

    public Droid getDroid(int index) {
        return droids.get(index);
    }

}
