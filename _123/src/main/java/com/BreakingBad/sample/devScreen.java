package com.BreakingBad.sample;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class devScreen extends Application implements Initializable
{

    public ListView<String> tasks_list;
    public static Stage primStage;
    private ArrayList<Assignment> assg_list;
    private ArrayList<String> assgList;
    public devScreen() throws Exception
    {
        assg_list = new ArrayList<>();
        assgList = new ArrayList<>();
        Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","karan");
        Statement stmt  = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from assignments where resource = \"Developer 1\" AND proj_id = 1");

        while(rs.next())
        {
            assg_list.add(new Assignment(rs.getString(1),rs.getString(2),rs.getInt(3)));
            assg_list.get(assg_list.size()-1).setProgress(rs.getDouble(4));
        }

        conn.close();
        for(int i=0;i<assg_list.size();i++)
        {
            assgList.add(assg_list.get(i).task+" "+assg_list.get(i).progress);
        }
    }
    public void start(Stage primaryStage) throws Exception
    {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/devScreen.fxml"));

        primaryStage.setTitle("Developer Screen");

        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<String> assg = FXCollections.observableArrayList(assgList);
        tasks_list.setItems(assg);


    }
    public void recProgress() throws Exception
    {
        RecordProgress.assg = assg_list.get(tasks_list.getSelectionModel().getSelectedIndex());
        RecordProgress recordProgress = new RecordProgress();
        recordProgress.start(primStage);
    }
}
