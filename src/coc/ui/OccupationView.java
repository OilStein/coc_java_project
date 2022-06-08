package coc.ui;

import coc.database.Occupations;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;

public class OccupationView {
    private Occupations occupations;


    public OccupationView(Occupations occupations) {
        this.occupations = occupations;
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();

        // List at left
        ListView<String> list = new ListView<>();
        ArrayList<String> occ = new ArrayList<>(occupations.getKeys());
        Collections.sort(occ);
        ObservableList<String> items = FXCollections.observableArrayList(occ);
        list.setItems(items);
        list.getSelectionModel().selectFirst();
        list.setPrefWidth(200);
        layout.setLeft(list);

        // Selection label: Default
        String selection = list.getSelectionModel().getSelectedItem();
        System.out.println(selection);
        Label title = new Label(selection);
        title.setFont(new Font("Arial", 40));
        Label description = new Label(occupations.getOccupation(selection).getDescription());
        description.setWrapText(true);
        Label occPoints = new Label(occupations.getOccupation(selection).getPoints());
        Label credit = new Label(occupations.getOccupation(selection).getCreditRating());
        Label contacts = new Label(occupations.getOccupation(selection).getContacts());
        Label skills = new Label(occupations.getOccupation(selection).getSkills());
        skills.setWrapText(true);

        // Listener that updates info block
        list.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String old, String newValue) {
                        title.setText(newValue);
                        description.setText(occupations.getOccupation(newValue).getDescription());
                        occPoints.setText(occupations.getOccupation(newValue).getPoints());
                        credit.setText(occupations.getOccupation(newValue).getCreditRating());
                        contacts.setText(occupations.getOccupation(newValue).getContacts());
                        skills.setText(occupations.getOccupation(newValue).getSkills());
                    }
                }
        );

        GridPane grid = new GridPane();
        grid.setHgap(5.0);
        grid.setVgap(5.0);
        grid.setPadding(new Insets(5));

        grid.add(title, 0, 0);

        grid.add(new Label("Description: "), 0, 1);
        grid.add(description, 0, 2);

        grid.add(new Label("Occupation Skill Points: "), 0, 3);
        grid.add(occPoints, 0, 4);

        grid.add(credit, 0, 6);
        grid.add(contacts, 0, 8);
        grid.add(skills, 0, 10);


        layout.setCenter(grid);

        return layout;

    }

}
