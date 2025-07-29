package com.example.loginscreen.controller;

import com.example.loginscreen.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label detailsWelcomeLabel;

    @FXML
    private Label detailsName;

    @FXML
    private Label detailsAgeId;

    @FXML
    private Label detailsProfession;

    @FXML
    private Label detailsWeb;

    @FXML
    private Label detailsTwitter;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXTextField loginUsername;



    @FXML
    void initialize() {

        loginUsername.setStyle("-fx-text-inner-color: #a0a2ab");
        loginPassword.setStyle("-fx-text-inner-color: #a0a2ab");

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    loginUser();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(loginUsername.getText() + "\nPassword:" + loginPassword.getText());
            }
        });

    }

    private void loginUser() throws IOException {
        // Get the main window
        loginButton.getScene().getWindow().hide();

        if(!loginUsername.getText().toString().trim().equals("") && !loginPassword.getText().toString().trim().equals("")) {
            // We are ready to go
            Stage detailsStage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("com.example.loginscreen.details.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/loginscreen/details.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 400);
            detailsStage.setScene(scene);
            detailsStage.show();
            detailsStage.setResizable(false);
        }
    }
}
