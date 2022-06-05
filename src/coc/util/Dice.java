package coc.util;

import java.util.Random;

public class Dice {

    public int rollCharacteristic(){
        Random roller = new Random();
        return (roller.nextInt(15) + 3) * 5;
    }

    public int roll100() {
        Random roller = new Random();
        return roller.nextInt(100) + 1;
    }

    public int rollDie(int times, int faces){
        Random roller = new Random();
        int sum = 0;
        for (int i = 0; i < times; i++){
            sum += roller.nextInt(faces) + 1;
        }
        return sum;
    }
}
