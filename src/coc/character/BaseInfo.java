package coc.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseInfo {
    private String name;
    private String player;
    private int age;
    private String sex;
    private String residence;
    private String birthplace;

    public void generateBaseInfo() {
        String[] gender = {"Male", "Female", "Other"};
        Random random = new Random();
        this.setName("Investigator#" + random.nextInt(100000));
        this.setPlayer("Tester");
        this.setAge(random.nextInt(100) + 18);
        this.setSex(gender[random.nextInt(2)]);
        this.setResidence("Test City#" + random.nextInt(100000));
        this.setBirthplace("Test#" + random.nextInt(100000));
    }

    public String toString() {
        return this.name;
    }
}