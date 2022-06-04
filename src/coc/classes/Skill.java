package coc.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Skill extends NameFullHalfFifth {

    public Skill(String name, int full){
        super(name, full);
    }


}
