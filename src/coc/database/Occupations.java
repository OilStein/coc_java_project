package coc.database;

import coc.character.Occupation;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Occupations {

    private HashMap<String, Occupation> occupations;

    public Occupations() {
        this.occupations = new HashMap<>();
    }

    public void initOccupations() {
        try (Scanner scanner = new Scanner(Paths.get("occupations.txt"))) {
            boolean title = true;
            boolean desc = true;
            while (scanner.hasNextLine()) {
                Occupation occupation = new Occupation();
                String line = scanner.nextLine();
                if (title) {
                    occupation.setName(line);
                    title = false;

                    StringBuilder description = new StringBuilder();
                    while (desc) {
                        String descLine = scanner.nextLine();
                        if (descLine.contains("Occupation Skill Points:")) {
                            occupation.setPoints(descLine);
                            desc = false;
                            break;
                        }
                        description.append(descLine);
                    }
                    occupation.setDescription(description.toString());
                    occupation.setCreditRating(scanner.nextLine());
                    occupation.setContacts(scanner.nextLine());
                    occupation.setSkills(scanner.nextLine());

                    occupations.put(occupation.getName(), occupation);
                }
                if (line.isEmpty()) {
                    title = true;
                    desc = true;
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Occupations: " + occupations.keySet() + "\n" + occupations.values();
    }
}
