package com.easternpearl.tasktracker.control;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControlManager {

    public static void loardScene(Stage stage,String fxmlFilePath){

            try {
                Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(ControlManager.class.getResource(fxmlFilePath))));
                stage.setScene(scene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        stage.show();
        stage.requestFocus();
    }
}
