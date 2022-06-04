package coc.classes;

import coc.database.Characteristics;
import coc.database.Skills;
import lombok.Data;

import java.util.Random;

@Data
public class Character {

    private BaseInfo baseInfo;
    private Characteristics characteristics;
    private Occupation occupation;
    private Skills skills;

    public Character(){
        this.baseInfo = new BaseInfo();
        this.characteristics = new Characteristics();
        this.occupation = new Occupation();
        this.skills = new Skills();
    }

    public void generateCharacter(){
        setBaseInfo(baseInfo.generateBaseInfo());
        characteristics.rollCharacteristics();
        setOccupation(occupation.makeAlienist());

    }

    @Override
    public String toString(){
        return baseInfo.getName();
    }
}
