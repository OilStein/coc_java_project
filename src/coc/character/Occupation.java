package coc.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Occupation {

    private String name;
    private String favCharacteristic;
    private String favSkills;
    private String creditRating;

    public void makeAlienist() {
        this.name = "Alienist";
        this.favCharacteristic = "EDU x 4";
        this.favSkills = "Law, Listen, Medicine, Other Language, Psychoanalysis, Psychology, Science (Biology), Science (Chemistry)";
        this.creditRating = "10-60";
    }

    public String toString() {
        return "Occupation: " + this.name;
    }
}
