package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class fortyController extends Application {
    private TextField nomField;
    private TextField prenomField;
    private TextField adresseField;
    private TextField nomStationField;
    private TextField codePostalField;
    private TextField communeField;
    private TextField nbBornettesField;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setVgap(10);
        root.setHgap(10);

        Label nomLabel = new Label("Nom :");
        nomField = new TextField();

        Label prenomLabel = new Label("Prénom :");
        prenomField = new TextField();

        Label adresseLabel = new Label("Adresse de la station :");
        adresseField = new TextField();

        Label nomStationLabel = new Label("Nom de la station :");
        nomStationField = new TextField();

        Label codePostalLabel = new Label("Code postal :");
        codePostalField = new TextField();

        Label communeLabel = new Label("Commune :");
        communeField = new TextField();

        Label nbBornettesLabel = new Label("Nombre de bornettes demandées :");
        nbBornettesField = new TextField();

        Button enregistrerButton = new Button("Enregistrer");
        enregistrerButton.setOnAction(event -> enregistrer());

        root.addRow(0, nomLabel, nomField);
        root.addRow(1, prenomLabel, prenomField);
        root.addRow(2, adresseLabel, adresseField);
        root.addRow(3, nomStationLabel, nomStationField);
        root.addRow(4, codePostalLabel, codePostalField);
        root.addRow(5, communeLabel, communeField);
        root.addRow(6, nbBornettesLabel, nbBornettesField);
        root.addRow(7, enregistrerButton);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void enregistrer() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String nomStation = nomStationField.getText();
        String codePostal = codePostalField.getText();
        String commune = communeField.getText();
        String nbBornettes = nbBornettesField.getText();

        Map<String, String> map = new HashMap<>();
        map.put("nom", nom);
        map.put("prenom", prenom);
        map.put("adresse", adresse);
        map.put("nomStation", nomStation);
        map.put("codePostal", codePostal);
        map.put("commune", commune);
        map.put("nbBornettes", nbBornettes);

        JSONObject jsonObject = new JSONObject(map);

        try (FileWriter file = new FileWriter("proposition-velov.json")) {
            file.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
