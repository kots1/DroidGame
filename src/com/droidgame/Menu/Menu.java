package com.droidgame.Menu;

import com.droidgame.Collection.DroidCollection;
import com.droidgame.Collection.GameScanner;
import com.droidgame.arena.ComputerVSComputer;
import com.droidgame.arena.PlayerVSComputer;
import com.droidgame.arena.PlayerVSPlayer;
import com.droidgame.arena.templateArena;
import com.droidgame.model.Droid;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final int PLAY = 1;
    private static final int PRINT = 2;
    private static final int CREATE = 3;
    private static final int DELETE = 4;
    private static final int EXIT = 5;

    public void menu(DroidCollection droidCollection) {
        int choice;
        while ((choice = chooseItemOfMenu()) != EXIT) {
            switch (choice) {
                case PRINT -> droidCollection.printDroids();
                case CREATE -> droidCollection.createDroid();
                case DELETE -> delete(droidCollection);
                case PLAY -> play(droidCollection);
            }
        }
    }

    private void play(DroidCollection droidCollection) {

        templateArena arena = preGameSetting(droidCollection);
        arena.Fight();
        droidCollection.reset();
    }

    private templateArena preGameSetting(DroidCollection droidCollection) {
        int countOfDroids = chooseCountOfDroids();
        ArrayList<Droid> firstTeam = chooseTeam(countOfDroids, droidCollection);
        ArrayList<Droid> secondTeam = chooseTeam(countOfDroids, droidCollection);
        return createArena(firstTeam,secondTeam);
    }

    private templateArena createArena(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        GameScanner scanner = new GameScanner();
        int typeOfArena= scanner.typeOfArena();
        return switch (typeOfArena) {
            case 1 -> new ComputerVSComputer(firstTeam, secondTeam);
            case 2 -> new PlayerVSComputer(firstTeam, secondTeam);
            case 3 -> new PlayerVSPlayer(firstTeam, secondTeam);
            default -> null;
        };
    }

    private ArrayList<Droid> chooseTeam(int count,DroidCollection droidCollection){
        ArrayList<Droid> team=new ArrayList<>();
        GameScanner scanner = new GameScanner();
        for (int i = 0; i < count; i++) {
            team.add(scanner.chooseDroid(droidCollection));
        }
        return team;
    }

    private int chooseCountOfDroids() {
        System.out.println("Input count of droids in one team");
        return new Scanner(System.in).nextInt();
    }

    private void delete(DroidCollection droidCollection) {
        droidCollection.printDroids();
        System.out.println("Choose droid to delete: ");
        droidCollection.deleteDroid(new Scanner(System.in).nextInt() - 1);
    }


    private int chooseItemOfMenu() {
        System.out.println("\nMenu:");
        System.out.println("1)play");
        System.out.println("2)print exist droids");
        System.out.println("3)create droid");
        System.out.println("4)delete droid");
        System.out.println("5)exit");
        return new Scanner(System.in).nextInt();
    }



}
