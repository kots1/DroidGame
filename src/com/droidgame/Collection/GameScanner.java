package com.droidgame.Collection;

import com.droidgame.Weapon.Weapon;
import com.droidgame.model.Droid;

import java.util.Scanner;

public class GameScanner {
    private final Scanner scanner = new Scanner(System.in);

    private final WeaponCollection weaponCollection;

    public int typeOfArena(){
        Scanner scanner=new Scanner(System.in);
        int choose;
        System.out.println("Type of arenas:");
        System.out.println("1)computer vs computer");
        System.out.println("2)player vs computer");
        System.out.println("3)player vs player");
        System.out.print("Choose type: ");
        while (true) {
            choose = scanner.nextInt();
            if (choose > 0 && choose <=3) {
                return choose;
            }
            System.out.print("Input error , try again :");
        }
    }

    public Droid chooseDroid(DroidCollection droidCollection) {
        droidCollection.printDroids();
        System.out.println("Choose droid");
        int choice = scanner.nextInt();
        return droidCollection.getDroid(choice - 1);
    }

    public GameScanner() {
        weaponCollection = new WeaponCollection();
    }

    public Weapon chooseWeapon() {
        int choice;
        System.out.println("Choose weapon:\n0)none");
        weaponCollection.printWeapon();
        while (true) {
            choice = scanner.nextInt();
            if (choice <= weaponCollection.getNumberOfWeapons() && choice >= 0) {
                if (choice == 0) {
                    return null;
                }
                return weaponCollection.getWeapon(choice - 1);
            }
            System.out.print("Input error , try again :");
        }
    }

    public String inputName() {
        System.out.print("Input name of droid: ");
        return scanner.nextLine();
    }

    public int inputData(String name) {
        int data;
        System.out.print("Input " + name + " : ");
        while (true) {
            data = scanner.nextInt();
            if (data >= 0) {
                return data;
            }
            System.out.print("Input error , try again :");
        }
    }

    public int inputPercent(String name) {
        int data;
        System.out.print("Input " + name + " : ");
        while (true) {
            data = scanner.nextInt();
            if (data >= 0 && data <= 100) {
                return data;
            }
            System.out.print("Input error , try again :");
        }
    }
}
