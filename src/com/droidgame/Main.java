package com.droidgame;

import com.droidgame.AdditionClasses.Collection.DroidCollection;
import com.droidgame.Menu.Menu;
import com.droidgame.model.Droid;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Menu menu = new Menu();
        DroidCollection droidCollection = main.inputDroidFromFile();

        menu.menu(droidCollection);
        main.gameOver(droidCollection);
    }

    private void gameOver(DroidCollection collection) {
        try {
            FileOutputStream fs = new FileOutputStream("droid.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            ArrayList<Droid> saveArray = collection.getArray();
            for (Droid droid : saveArray) {
                os.writeObject(droid);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DroidCollection inputDroidFromFile() {
        ArrayList<Droid> saveArray = new ArrayList<>();
        try {
            FileInputStream fs = new FileInputStream("droid.ser");
            if (fs.available() <= 0) {
                return new DroidCollection(saveArray);
            }
            ObjectInputStream os = new ObjectInputStream(fs);
            Droid droid;
            while ((fs.available()) > 0) {
                droid = (Droid) os.readObject();
                saveArray.add(droid);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return new DroidCollection(saveArray);
    }

}
