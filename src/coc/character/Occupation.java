package coc.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Occupation {

    private String name;
    private String description;
    private String points;
    private String skills;
    private String creditRating;
    private String contacts;

    public void makeAlienist() {
        this.name = "Alienist";
        this.points = "EDU x 4";
        this.skills = "Law, Listen, Medicine, Other Language, Psychoanalysis, Psychology, Science (Biology), Science (Chemistry)";
        this.creditRating = "10-60";
    }

    @Override
    public String toString() {
        return this.name + "\n" +
                this.description + "\n" +
                this.points + "\n" +
                this.creditRating + "\n" +
                this.contacts + "\n" +
                this.skills + "\n";
    }
}
