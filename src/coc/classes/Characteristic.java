package coc.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characteristic extends NameFullHalfFifth{

    public Characteristic(String name, int full){
        super(name, full);
    }

}
