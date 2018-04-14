package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.ListView;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewPrev extends Application implements Initializable
{
    public static Stage primStage;
    public ListView<String> projList;
    private ArrayList<String> proj_list;

    public ViewPrev() throws Exception
    {

        proj_list= new ArrayList<>();
        //Fetch Project List
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","karan");

        Statement stmt  = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id from projects");
        while(rs.next())
            proj_list.add("Project "+rs.getInt(1) +"");
        conn.close();

    }
    public void allocateTasks() throws Exception
    {
        int projID=Integer.parseInt(projList.getSelectionModel().getSelectedItem().split(" ")[1]);
        AllocateTasks.proj_id = projID;
        AllocateTasks at = new AllocateTasks();
        AllocateTasks.primStage = primStage;
        at.start(primStage);
    }
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("viewPrev.fxml"));
        primaryStage.setTitle("View Project");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }
    public void getAssignments() throws Exception
    {
        GetAssign.proj_id = Integer.parseInt(projList.getSelectionModel().getSelectedItem().split(" ")[1]);
        GetAssign getAssign = new GetAssign();
        GetAssign.prim_stage= primStage;
        getAssign.start(primStage);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        ObservableList<String> projects = FXCollections.observableArrayList(proj_list);
        projList.setItems(projects);

    }
}
