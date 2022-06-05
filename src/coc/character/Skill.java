package coc.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private String name;
    private int level;
    private String rarity;

    public String toString() {
        return this.name + ":" + this.level;
    }

    public void setPoints(int points) {
        if (this.level + points < 100) {
            this.level += points;
        }
    }
}
