package com.BreakingBad.sample;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller.primStage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));

        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
