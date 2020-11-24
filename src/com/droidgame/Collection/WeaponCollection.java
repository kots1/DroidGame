package com.droidgame.Collection;

import com.droidgame.Weapon.*;

import java.util.ArrayList;

public class WeaponCollection {
    private ArrayList<Weapon> arrayWeapon;

    public WeaponCollection() {
        createArrayWeapon();
    }

    private void createArrayWeapon() {
        arrayWeapon = new ArrayList<>();
        arrayWeapon.add(new scepter());
        arrayWeapon.add(new shield());
        arrayWeapon.add(new shoes());
        arrayWeapon.add(new shotgun());
        arrayWeapon.add(new sniper());
    }

    public void printWeapon() {
        int i = 1;
        for (Weapon weapon : arrayWeapon) {
            System.out.println((i++) + ") " + weapon);
        }
    }

    public Weapon getWeapon(int index) {
        return arrayWeapon.get(index);
    }

    public int getNumberOfWeapons() {
        return arrayWeapon.size();
    }
}
