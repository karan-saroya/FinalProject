package com.BreakingBad.sample;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class RecordProgress extends Application implements Initializable
{
    public Spinner<Double> progressSpinner;
    public static Assignment assg;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/recordProgress.fxml"));

        primaryStage.setTitle("Record Progress");

        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();


    }
    public void updateProgress() throws Exception
    {
        double progress = progressSpinner.getValue();
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","karan");

        String query = "update assignments set progress = ? where task = ? AND resource = ? AND proj_id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setDouble   (1, progress);

        preparedStmt.setString   (2, assg.task);
        preparedStmt.setString(3, assg.resource);
        preparedStmt.setInt(4, 1);
        preparedStmt.executeUpdate();

        conn.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        SpinnerValueFactory<Double> updProg = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1000,assg.progress);
        progressSpinner.setValueFactory(updProg);
    }
}
