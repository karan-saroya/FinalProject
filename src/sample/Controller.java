package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.*;

public class Controller
{
    @FXML
    private TextField user_txt;

    public static Stage primStage;
    public void handleLogin(ActionEvent actionEvent) throws Exception
    {
        System.out.println(user_txt.getText());
        new devScreen().start(primStage);

    }
}
