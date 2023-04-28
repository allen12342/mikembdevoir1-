package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondaryController extends Application {
    private ListView<String> listView;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        
        TextField filterField = new TextField();
        filterField.setPromptText("Filtrer par arrondissement");

        
        listView = new ListView<>();
        refreshData();

       
        VBox vBox = new VBox(filterField, listView);
        root.setCenter(vBox);

            
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            refreshData();
        });

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void refreshData() {
        // get data from API and filter by arrondissement
        String arrondissementFilter = "";
        if (listView != null && listView.getItems().size() > 0) {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null && !selectedItem.isEmpty()) {
                arrondissementFilter = selectedItem.split(" ")[1];
            }
        }

        

        
        listView.getItems().clear();
        listView.getItems().addAll("Lyon 1", "Lyon 2", "Lyon 3", "Lyon 4", "Lyon 5", "Lyon 6", "Lyon 7", "Lyon 8", "Lyon 9");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
