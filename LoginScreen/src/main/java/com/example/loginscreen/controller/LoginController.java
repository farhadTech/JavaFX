package com.example.loginscreen.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private JFXTextField loginUsername;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginButton;


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

        if(!loginUsername.getText().trim().isEmpty() && !loginPassword.getText().trim().isEmpty()) {
            // We are ready to go

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/loginscreen/details.fxml"));
            loader.load();

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            DetailsController detailsController = loader.getController();
            detailsController.setDetails(loginUsername.getText(), 31, "Web and App Developer");
            stage.show();
        }
    }
}
