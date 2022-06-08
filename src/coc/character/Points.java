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
        // EDU x 4
        if (occ.getPoints().length() < 10) {
            String[] specs = occ.getPoints().split("x");
            System.out.println(Arrays.toString(specs));
            if (specs.length == 2) {
                int eduMultiplier = Integer.parseInt(specs[1].trim());
                this.occupationPoints = eduMultiplier * cha.getCharacteristicValue("EDU");
            }
        }

        // EDU x 2 + APP x 2
        if (occ.getPoints().contains("+") && !occ.getPoints().contains("(")) {
            String[] line = occ.getPoints().split("\\+");

            String[] edu = line[0].split("x");
            int eduMultiplier = Integer.parseInt(edu[1].trim());

            String[] other = line[1].split("x");
            String otherCharacteristic = other[0].trim();
            int otherMultiplier = Integer.parseInt(other[1].trim());

            this.occupationPoints = eduMultiplier * cha.getCharacteristicValue("EDU") + otherMultiplier * cha.getCharacteristicValue(otherCharacteristic);
        }

        // EDU x 2 + (APP x 2 or DEX x 2)
        if (occ.getPoints().contains("+") && occ.getPoints().contains("(")) {
            // EDU x 2 ; (APP x 2 or DEX x 2)
            String[] line = occ.getPoints().split("\\+");

            String[] edu = line[0].split("x");
            int eduMultiplier = Integer.parseInt(edu[1].trim());

            // (APP x 2 or DEX x 2)
            String[] splitter = line[1].split("or");
            // (APP x 2
            String[] first = splitter[0].split("x");
            String fChar = first[0].substring(2).trim();
            int fMulti = Integer.parseInt(first[1].trim());
            int value1 = fMulti * cha.getCharacteristicValue(fChar);
            // DEX x 2)
            String[] second = splitter[0].split("x");
            String sChar = second[0].substring(2).trim();
            System.out.println(sChar);
            int sMulti = Integer.parseInt(second[1].substring(0, second[1].length() - 1).trim());
            int value2 = sMulti * cha.getCharacteristicValue(sChar);

            // chooses better
            this.occupationPoints = eduMultiplier * cha.getCharacteristicValue("EDU") + Math.max(value1, value2);

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
