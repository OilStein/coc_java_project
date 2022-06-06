package coc;

import coc.character.Character;
import coc.database.Occupations;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("CoC - Main");
        window.setHeight(360);
        window.setWidth(360);
        window.show();
    }

    public static void main(String[] args) {
        //launch(Main.class);
        Occupations occupations = new Occupations();
        occupations.initOccupations();
        Character test = new Character();
        test.generateCharacter(occupations);
        System.out.println(test);
        // System.out.println(occupations);
    }
}
