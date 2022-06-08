package coc.ui;

import coc.character.Occupation;
import coc.database.Characters;
import coc.database.Occupations;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MainView {

    private Characters characters;
    private Occupations occupations;

    public MainView(Characters characters, Occupations occupations) {
        this.characters = characters;
        this.occupations = occupations;
    }

    public Parent getView() {


        return new BorderPane();
    }

}
