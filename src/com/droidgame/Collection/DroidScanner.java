package com.droidgame.Collection;

import com.droidgame.Weapon.WeaponInterface;

import java.util.Scanner;

public class DroidScanner {
    private final Scanner scanner =new Scanner(System.in);

    private final WeaponCollection weaponCollection;

    public DroidScanner(){
        weaponCollection=new WeaponCollection();

    }
    public WeaponInterface chooseWeapon() {
        int choice;
        System.out.println("Choose weapon:\n0)none");
        weaponCollection.printWeapon();
        while (true){
            choice=scanner.nextInt();
            if(choice<=weaponCollection.getNumberOfWeapons()&&choice>=0){
                if(choice==0){
                    return null;
                }
                return weaponCollection.getWeapon(choice-1);
            }
            System.out.print("Input error , try again :");
        }
    }

    public String inputName(){
        System.out.print("Input name of droid: ");
        return scanner.nextLine();
    }

    public int inputData(String name){
        int data;
        System.out.print("Input "+name+" : ");
        while (true){
            data=scanner.nextInt();
            if(data>=0){
                return data;
            }
            System.out.print("Input error , try again :");
        }
    }

    public  int inputPercent(String name){
        int data;
        System.out.print("Input "+name+" : ");
        while (true){
            data=scanner.nextInt();
            if(data>=0&&data<=100){
                return data;
            }
            System.out.print("Input error , try again :");
        }
    }
}
