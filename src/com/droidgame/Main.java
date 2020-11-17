package com.droidgame;

import com.droidgame.Collection.DroidCollection;
import com.droidgame.Collection.WeaponCollection;
import com.droidgame.Weapon.*;
import com.droidgame.model.Droid;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final int PRINT =1;
    private static final int CREATE =2;
    private static final int DELETE =3;
    private static final int EXIT =4;

    public static void main(String[] args) {
        Main main =new Main();
        DroidCollection droidCollection=main.inputDroidFromFile();
        main.menu(droidCollection);
        main.gameOver(droidCollection);
    }

    private void menu(DroidCollection droidCollection){
        int choice;
            while ((choice=chooseItemOfMenu())!=EXIT){
                switch (choice) {
                    case PRINT -> droidCollection.printDroids();
                    case CREATE -> droidCollection.createDroid();
                    case DELETE -> delete(droidCollection);
                }
            }
        }

    private void delete(DroidCollection droidCollection) {
        droidCollection.printDroids();
        System.out.println("Choose droid to delete: ");
        droidCollection.deleteDroid(new Scanner(System.in).nextInt()-1);
    }


    private int chooseItemOfMenu(){
        System.out.println("\nMenu:");
        System.out.println("1)print exist droid");
        System.out.println("2)create droid");
        System.out.println("3)delete droid");
        System.out.println("4)exit");
        return new Scanner(System.in).nextInt();
    }

    private void gameOver(DroidCollection collection){
        try {
            FileOutputStream fs =new FileOutputStream("droid.ser");
            ObjectOutputStream os =new ObjectOutputStream(fs);
            ArrayList<Droid> saveArray = collection.getArray();
            for(Droid droid: saveArray){
                os.writeObject(droid);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DroidCollection inputDroidFromFile()  {
            ArrayList<Droid> saveArray = new ArrayList<>();
        try {
                FileInputStream fs =new FileInputStream("droid.ser");
                if(fs.available()<=0){
                    return new DroidCollection(saveArray);
                }
                ObjectInputStream os =new ObjectInputStream(fs);
                Droid droid;
                while ( (fs.available())>0){
                    droid=(Droid) os.readObject();
                    saveArray.add(droid);
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
        }
        return  new DroidCollection(saveArray);
    }


}
