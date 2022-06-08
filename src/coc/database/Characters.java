package coc.database;

import coc.character.Character;

import java.util.ArrayList;

public class Characters {
    private ArrayList<Character> characters;

    public Characters(){
        this.characters = new ArrayList<>();
    }

    public void generateCharacters(Occupations occupations) {
        for (int i = 0; i < 6; i++) {
            Character character = new Character();
            character.generateCharacter(occupations);
            characters.add(character);
        }
    }

    public void save() {

    }

}
