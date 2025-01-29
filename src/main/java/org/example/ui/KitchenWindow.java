package org.example.ui;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KitchenWindow extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        openWindow(primaryStage);
    }

    public void openWindow(Stage stage){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ui/Kitchen.fxml")); // Korrekte FXML-Datei angeben
            System.out.println("Resource URL: " + loader.getLocation());
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("User Profile"); // Titel des Fensters entsprechend ändern
            stage.show();
        }

        catch(IOException e){
            e.printStackTrace();
        }
    }
}
