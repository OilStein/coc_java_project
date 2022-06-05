package coc.character;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Skills {

    private ArrayList<Skill> skills;

    public Skills() {
        this.skills = new ArrayList<>();
    }

    public void initSkills() {
        try (Scanner scanner = new Scanner(Paths.get("skills.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                Skill skill = new Skill(parts[0], Integer.parseInt(parts[1]), parts[2]);
                this.skills.add(skill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Skill getSkill(String query) {
        return this.skills.stream().filter(x -> query.equals(x.getName())).findAny().orElse(null);
    }

    public String toString() {
        return "Skills: " + this.skills;
    }

}
