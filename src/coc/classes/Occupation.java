package coc.classes;

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

    public Occupation makeAlienist(){
        return new Occupation(
                "Alienist",
                "EDU x 4",
                "Law, Listen, Medicine, Other Language, Psychoanalysis, Psychology, Science (Biology), Science (Chemistry)",
                "10-60");
    }

}
