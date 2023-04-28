package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimaryController extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btnConsulter = new Button("Consulter les données");
        Button btnTelecharger = new Button("Télécharger le fichier");
        Button btnProposer = new Button("Proposer une station");
        Button btnSupprimer = new Button("Supprimer une proposition");

        VBox root = new VBox(btnConsulter, btnTelecharger, btnProposer, btnSupprimer);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
