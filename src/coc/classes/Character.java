package coc.classes;

public class Character {

    private String name;
    private String player;
    private Occupation occupation;
    private int age;
    private String sex;
    private String residence;
    private String birthplace;

    public Character(String name, String player, Occupation occupation, int age, String sex, String residence, String birthplace){
        this.name = name;
        this.player = player;
        this.occupation = occupation;
        this.age = 0;
        this.sex = sex;
        this.residence = residence;
        this.birthplace = birthplace;
    }

    public Character(String name, String player, Occupation occupation){
        this.name = name;
        this.player = player;
        this.occupation = occupation;
    }
}
