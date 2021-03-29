package layer_presentation.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import layer_business.Functions;
import layer_presentation.GUI;
import layer_presentation.util.AlertBox;

import java.io.IOException;

public class ControllerLogin {

    @FXML
    public Button loginButton;

    @FXML
    public TextField mail;

    @FXML
    public TextField password;


    public void login() throws IOException {
        Functions f = new Functions();

        if(mail.getText().equals("") || password.getText().equals(""))
            AlertBox.display("No input", "You forgot to write your mail/password");
        else {
            System.out.println(f.loginPlayer(mail.getText(), password.getText()));
            Scene scene = GUI.changeScene("user.fxml");
        }


    }


}
