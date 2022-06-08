package coc;

import coc.character.Character;
import coc.database.Characters;
import coc.database.Occupations;
import coc.ui.CharacterView;
import coc.ui.OccupationView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Characters characters;
    private Occupations occupations;

    @Override
    public void init() {
        this.characters = new Characters();
        this.occupations = new Occupations();
    }

    @Override
    public void start(Stage window) {
        OccupationView occupationView = new OccupationView(occupations);
        CharacterView characterView = new CharacterView(characters);

        BorderPane layout = new BorderPane();

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(10);

        Button toOccupations = new Button("Occupations");
        Button toCharacters = new Button("Characters");

        hBox.getChildren().addAll(toCharacters, toOccupations);
        layout.setTop(hBox);

        toCharacters.setOnAction((event) -> layout.setCenter(characterView.getView()));
        toOccupations.setOnAction((event) -> layout.setCenter(occupationView.getView()));

        layout.setCenter(occupationView.getView());


        Scene view = new Scene(layout, 800, 600);

        window.setTitle("CoC - Main");
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }

}
