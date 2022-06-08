package coc.character;

import coc.util.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Characteristics {
    public String[] CHARACTERISTICS = {"STR", "CON", "SIZ", "DEX", "APP", "INT", "POW", "EDU"};

    private HashMap<String, Characteristic> characteristics;

    public Characteristics() {
        this.characteristics = new HashMap<>();
    }

    public void rollCharacteristics() {
        Dice dice = new Dice();
        for (String name : CHARACTERISTICS) {
            Characteristic characteristic;
            if (name.equals("INT") || name.equals("EDU") || name.equals("SIZ")) {
                characteristic = new Characteristic(name, (dice.rollDie(2, 6) + 6) * 5);
            } else {
                characteristic = new Characteristic(name, dice.rollCharacteristic());
            }
            this.characteristics.put(name, characteristic);
        }
    }

    public Characteristic getCharacteristic(String query) {
        return this.characteristics.get(query);
    }

    public int getCharacteristicValue(String query) {
        return this.characteristics.get(query).getValue();
    }

    @Override
    public String toString() {
        return "Characteristics: " + characteristics.values();
    }
}
