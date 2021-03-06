package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.presentationModel.PlayerUi;
import org.example.presentationModel.TicTacBoard;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(PlayerUi.loadPlayerUi(),640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(Parent root){
        scene.setRoot(root);
    }

    public static void main(String[] args) {
        launch();
    }

}
