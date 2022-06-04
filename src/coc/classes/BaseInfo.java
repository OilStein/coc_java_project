package coc.classes;

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

    public BaseInfo generateBaseInfo(){
        Random random = new Random();
        return new BaseInfo("Name" + random.nextInt(10000), "NaN" , random.nextInt(80) + 20, "Male" , "New York", "Finland" );
    }
}
