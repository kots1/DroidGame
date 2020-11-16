package com.droidgame;

import com.droidgame.Weapon.*;
import com.droidgame.arena.mainArena;
import com.droidgame.model.Droid;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        ArrayList<WeaponInterface> weapon=main.arrayWeapon();
        main.printWeapon(weapon);
        //Droid first =new Droid("Volodia",200,40,50,10);
        //Droid second =new Droid("Vlad",200,40,10,100);
       // mainArena arena = new mainArena(first,second);
       // arena.Fight();
    }
    private ArrayList<WeaponInterface> arrayWeapon(){
        ArrayList<WeaponInterface> weaponArrayList=new ArrayList<>();
        weaponArrayList.add(new scepter());
        weaponArrayList.add(new shield());
        weaponArrayList.add(new shoes());
        weaponArrayList.add(new shotgun());
        weaponArrayList.add(new sniper());
        return  weaponArrayList;
    }
    private void printWeapon(ArrayList<WeaponInterface> weapons){
        for (WeaponInterface weapon :weapons){
            System.out.println(weapon);
        }
    }
}
