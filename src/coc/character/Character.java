package coc.character;

import lombok.Data;

@Data
public class Character {

    private BaseInfo baseInfo;
    private Characteristics characteristics;
    private Occupation occupation;
    private Skills skills;
    private Points points;

    public Character(){
        this.baseInfo = new BaseInfo();
        this.characteristics = new Characteristics();
        this.occupation = new Occupation();
        this.skills = new Skills();
        this.points = new Points();
    }

    public void generateCharacter() {
        this.baseInfo.generateBaseInfo();
        this.characteristics.rollCharacteristics();
        this.occupation.makeAlienist();
        this.skills.initSkills();
        this.points.calculatePoints(
                this.characteristics.getCharacteristic("STR").getValue(),
                this.characteristics.getCharacteristic("DEX").getValue(),
                this.characteristics.getCharacteristic("CON").getValue(),
                this.characteristics.getCharacteristic("SIZ").getValue(),
                this.characteristics.getCharacteristic("POW").getValue(),
                this.baseInfo.getAge()
        );
    }

    @Override
    public String toString() {
        return baseInfo + "\n" +
                occupation + "\n" +
                characteristics + "\n" +
                skills + "\n" +
                points;
    }
}
