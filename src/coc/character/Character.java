package coc.character;

import coc.database.Occupations;
import lombok.Data;

@Data
public class Character {

    private BaseInfo baseInfo;
    private Characteristics characteristics;
    private Occupation occupation;
    private Skills skills;
    private Points points;

    public Character() {
        this.baseInfo = new BaseInfo();
        this.characteristics = new Characteristics();
        this.occupation = new Occupation();
        this.skills = new Skills();
        this.points = new Points();
    }

    public void generateCharacter(Occupations occupations) {
        this.baseInfo.generateBaseInfo();
        this.characteristics.rollCharacteristics();
        setOccupation(occupations.getRandomOccupation());
        this.skills.initSkills();
        // This could contain whole characteristic list instead of singles
        this.points.calculatePoints(
                this.characteristics,
                this.baseInfo.getAge(),
                this.occupation
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
