package coc.character;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Characteristic {
    private String name;
    private int value;

    public String toString() {
        return this.name + ":" + this.value;
    }
}