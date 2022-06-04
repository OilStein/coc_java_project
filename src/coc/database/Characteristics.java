package coc.database;

import coc.classes.Characteristic;
import  coc.util.Dice;
import java.util.ArrayList;

public class Characteristics {
    public String[] CHARACTERISTICS = {"STR", "CON", "SIZ", "DEX", "APP", "INT", "POW", "EDU"};

    private ArrayList<Characteristic> characteristics;

    public Characteristics() {
        this.characteristics = new ArrayList<>();
    }

    public void rollCharacteristics(){
        Dice dice = new Dice();
        for (String name:CHARACTERISTICS) {
            Characteristic characteristic = new Characteristic(name, dice.rollCharacteristic());
            this.characteristics.add(characteristic);
        }
    }

}
