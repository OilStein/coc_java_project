package coc.character;

import coc.util.Dice;

public class Points {
    private int build;
    private int hp;
    private int sanity;
    private int luck;
    private int magic;
    private int movement;

    public Points() {
        this.build = 0;
        this.hp = 0;
        this.sanity = 0;
        this.luck = 0;
        this.magic = 0;
        this.movement = 0;
    }

    public void calculatePoints(int str, int dex, int con, int siz, int pow, int age) {
        calculateBuild(str, siz);
        calculateHP(con, siz);
        calculateMagic(pow);
        calculateLuck();
        calculateSanity(pow);
        calculateMovement(str, dex, siz, age);
    }

    @Override
    public String toString() {
        return "Points: \n" +
                "Build: " + build + "\n" +
                "HP: " + hp + "\n" +
                "Sanity: " + sanity + "\n" +
                "Luck: " + luck + "\n" +
                "Magic: " + magic + "\n" +
                "Movement: " + movement;
    }

    private void calculateBuild(int str, int siz) {
        int sum = str + siz;
        if (sum >= 2 && sum <= 64) {
            this.build = -2;
        } else if (sum >= 65 && sum <= 84) {
            this.build = -1;
        } else if (sum >= 85 && sum <= 124) {
            this.build = 0;
        } else if (sum >= 125 && sum <= 164) {
            this.build = 1;
        } else {
            this.build = 2;
        }
    }

    private void calculateHP(int con, int siz) {
        this.hp = (int) Math.round(((con + siz) / 10.0) / 10.0) * 10;
    }

    private void calculateSanity(int pow) {
        this.sanity = pow;
    }

    private void calculateLuck() {
        Dice dice = new Dice();
        this.luck = 5 * (dice.rollDie(2, 6) + 6);
    }

    private void calculateMagic(int pow) {
        this.magic = pow / 5;
    }

    private void calculateMovement(int str, int dex, int siz, int age) {
        if (str < siz && dex < siz) {
            this.movement = 7;
        }
        if (str >= siz || dex >= siz) {
            this.movement = 8;
        }
        if (str >= siz && dex >= siz) {
            this.movement = 9;
        }
        if (age >= 80) {
            this.movement -= 5;
        } else if (age >= 70) {
            this.movement -= 4;
        } else if (age >= 60) {
            this.movement -= 3;
        } else if (age >= 50) {
            this.movement -= 2;
        } else if (age >= 40) {
            this.movement -= 1;
        }
    }
}
