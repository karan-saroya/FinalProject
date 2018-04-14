package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;





public class NewProjScreen extends Application implements Initializable
{
    public DatePicker startDate;
    public DatePicker endDate;

    public Spinner<Integer> spinDevelop;

    public Spinner<Integer> spinTester;

    public Spinner<Integer> spinDesigner;
    public TextField taskList;

    public static Stage primStage;

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Parent root = FXMLLoader.load(getClass().getResource("newProjScreen.fxml"));
        primaryStage.setTitle("New Project");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();

    }
    public void createProject(ActionEvent ae) throws Exception
    {
            LocalDate sdate = startDate.getValue();
            LocalDate edate = endDate.getValue();
            String num_develop =   spinDevelop.getValue().toString();
            String num_tester =   spinTester.getValue().toString();
            String num_design =   spinDesigner.getValue().toString();
            String tasks = taskList.getText();
            String[] list = tasks.split(",");
            Task tlist[] = new Task[1000];
            for(int i=0;i<list.length;i++)
            {
                String[] specific = list[i].split(" ");
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

                Task task = new Task(specific[0],Integer.parseInt(specific[1]), sdf.parse(specific[2]),sdf.parse(specific[3]),Project.num_projects);
                System.out.println(task.taskID);
                tlist[i]=task;
            }
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","karan");
        String query = " insert into tasks (name, id, start_date, end_date,proj_id)"
                + " values (?, ?, ?, ?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        // create the mysql insert preparedstatement
        for(int i=0;i<list.length;i++)
        {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, tlist[i].name);
            preparedStmt.setInt (2, tlist[i].taskID);
            preparedStmt.setDate   (3, new java.sql.Date(tlist[i].startDate.getTime()));
            preparedStmt.setDate(4, new java.sql.Date(tlist[i].startDate.getTime()));
            preparedStmt.setInt(5,Project.num_projects);

            // execute the preparedstatement
            preparedStmt.execute();
        }
        conn.close();

        Project proj = new Project(Date.from(sdate.atStartOfDay(ZoneId.systemDefault()).toInstant()),Date.from(edate.atStartOfDay(ZoneId.systemDefault()).toInstant()),sample.Project.num_projects,tlist);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SpinnerValueFactory<Integer> developFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1000,1);

        SpinnerValueFactory<Integer> testFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1000,1);

        SpinnerValueFactory<Integer> desFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1000,1);
        spinDevelop.setValueFactory(developFactory);
        spinTester.setValueFactory(testFactory);
        spinDesigner.setValueFactory(desFactory);
    }
}
