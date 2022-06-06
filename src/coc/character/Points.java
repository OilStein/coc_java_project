package coc.character;

import coc.util.Dice;

import java.util.Arrays;

public class Points {
    private int occupationPoints;
    private int interestPoints;

    private int build;
    private int hp;
    private int sanity;
    private int luck;
    private int magic;
    private int movement;

    public Points() {
        this.occupationPoints = 0;
        this.interestPoints = 0;
        this.build = 0;
        this.hp = 0;
        this.sanity = 0;
        this.luck = 0;
        this.magic = 0;
        this.movement = 0;
    }

    public void calculatePoints(Characteristics ch, int age, Occupation occ) {
        calculateOccupationPoints(ch, occ);
        calculateInterestPoints(ch.getCharacteristicValue("INT"));

        calculateBuild(ch.getCharacteristicValue("STR"), ch.getCharacteristicValue("CON"));
        calculateHP(ch.getCharacteristicValue("CON"), ch.getCharacteristicValue("SIZ"));
        calculateMagic(ch.getCharacteristicValue("POW"));
        calculateLuck();
        calculateSanity(ch.getCharacteristicValue("POW"));
        calculateMovement(
                ch.getCharacteristicValue("STR"),
                ch.getCharacteristicValue("DEX"),
                ch.getCharacteristicValue("SIZ"),
                age
        );
    }

    @Override
    public String toString() {
        return "Points: \n" +
                "Occupation Points: " + occupationPoints + "\n" +
                "Interest Points: " + interestPoints + "\n" +
                "Build: " + build + "\n" +
                "HP: " + hp + "\n" +
                "Sanity: " + sanity + "\n" +
                "Luck: " + luck + "\n" +
                "Magic: " + magic + "\n" +
                "Movement: " + movement;
    }

    private void calculateOccupationPoints(Characteristics cha, Occupation occ) {
        if (occ.getPoints().length() < 7) {
            String[] specs = occ.getPoints().split("x");
            System.out.println(Arrays.toString(specs));
            if (specs.length == 2) {
                int eduMultiplier = Integer.parseInt(specs[1].trim());
                this.occupationPoints = eduMultiplier * cha.getCharacteristicValue("EDU");
            }
        }
        if (occ.getPoints().contains("+") && !occ.getPoints().contains("(")) {
            int sum = 0;
            String[] specs = occ.getPoints().split("\\+");
            String[] first = specs[1].split("x");


        }

    }

    private void calculateInterestPoints(int intValue) {
        this.interestPoints = 2 * intValue;
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
