package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MgmtScreen  extends Application
{
    public static Stage primStage;
    @FXML
    private void newProject() throws Exception
    {
        NewProjScreen newProjScreen = new NewProjScreen();
        NewProjScreen.primStage=primStage;
        newProjScreen.start(primStage);
    }
    @FXML
    private void viewPrev()
    {

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("mgmtScreen.fxml"));
        primaryStage.setTitle("Management Screen");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }
}
