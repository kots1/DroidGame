package com.droidgame.Collection;

import com.droidgame.Weapon.WeaponInterface;
import com.droidgame.model.Droid;

import java.util.ArrayList;

public class DroidCollection {
    private final ArrayList<Droid> droids =new ArrayList<>();

    public void createDroid(){
        DroidScanner scan = new DroidScanner();
        String name=scan.inputName();
        int healthy=scan.inputData("healthy");
        int damage=scan.inputData("damage");
        int attack=scan.inputData("attack");
        int defence=scan.inputData("defence");
        int precision=scan.inputPercent("precision (0-100%)");
        int maxEnergy=scan.inputData("max energy");
        int increaseEnergy=scan.inputData("each round of energy increase");
        int opportunityToDodge=scan.inputPercent("opportunity to dodge (0-100%)");
        WeaponInterface weapon =scan.chooseWeapon();
        droids.add(new Droid(name,healthy,damage,attack,defence,precision,maxEnergy,increaseEnergy,opportunityToDodge,weapon));
    }



    public Droid getDroid(int index){
        return droids.get(index);
    }
}
