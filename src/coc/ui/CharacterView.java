package coc.ui;

import coc.database.Characters;
import coc.database.Occupations;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class CharacterView {

    private Characters characters;

    public CharacterView(Characters characters) {
        this.characters = characters;
    }

    public Parent getView() {
        BorderPane b = new BorderPane();


        return b;
    }


}
