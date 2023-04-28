package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class thirdryController extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btnTelecharger = new Button("Télécharger le fichier");
        btnTelecharger.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Sélectionner le dossier de téléchargement");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier JSON", "*.json"));
            File selectedFile = fileChooser.showSaveDialog(primaryStage);
            if (selectedFile != null) {
                try {
                    // URL de l'API
                    String apiUrl = "https://download.data.grandlyon.com/ws/rdata/jcd_jcdecaux.jcdvelov/all.json";

                   
                    URL url = new URL(apiUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                  
                    FileWriter writer = new FileWriter(selectedFile);
                    writer.write(response.toString());
                    writer.close();

                    System.out.println("Fichier téléchargé avec succès !");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        VBox root = new VBox(btnTelecharger);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
