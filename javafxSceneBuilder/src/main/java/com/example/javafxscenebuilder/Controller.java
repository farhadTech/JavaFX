package com.example.javafxscenebuilder;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXTextField textField;

    @FXML
    private Button clickMeButton;

    @FXML
    private JFXButton materialButton;

    @FXML
    private Label clickMeLabel;

    @FXML
    private Label materialButtonLabel;

    @FXML
    private Label textFieldLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Click Me Button is working");
                clickMeLabel.setText("Hey There!");
            }
        });

        materialButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Material Button is working");
                materialButtonLabel.setText("Material Button Clicked");
            }
        });

        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String textString = textField.getText();
                textFieldLabel.setText(textString);
            }
        });
    }
}
