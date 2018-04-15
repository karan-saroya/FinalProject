package com.BreakingBad.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.*;

import java.sql.*;

public class Controller
{

    public TextField user_txt;
    public PasswordField pass_txt;


    public static Stage primStage;
    public void handleLogin(ActionEvent actionEvent) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","karan");
        String username=user_txt.getText();
        String pass = pass_txt.getText();
        Statement stmt  = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select type from members where username = "+" \""+username+"\""+" AND password = "+"\""+pass+"\"");
        int type=-1;
        while(rs.next())
            type=rs.getInt(1);
        conn.close();

        if(type == 0)
        {
                //Open Mgmt Screen
            MgmtScreen mgmtScreen = new MgmtScreen();
            MgmtScreen.primStage = primStage;
            mgmtScreen.start(primStage);

        }
        else if(type == 1)
        {
                // Open Developer Screen
            devScreen devScr = new devScreen();
            devScreen.primStage = primStage;
            devScr.start(primStage);

        }

    }
}
