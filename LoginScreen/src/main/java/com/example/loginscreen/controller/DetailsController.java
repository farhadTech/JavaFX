package com.example.loginscreen.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailsController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label detailsName;

    @FXML
    private Label detailsProfession;

    @FXML
    private Hyperlink detailsTwitter;

    @FXML
    private Hyperlink detailsWeb;

    @FXML
    private Label detailsWelcomeLabel;

    @FXML
    private Label detailsAgeId;

    @FXML
    void initialize() {
        detailsWeb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://www.youtube.com/@MrBean"));
                    } catch(IOException e) {
                        e.printStackTrace();
                    } catch(URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        detailsTwitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://x.com/mrbean"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch(URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    void setDetails(String name, int age, String profession) {
        detailsWelcomeLabel.setText("Welcome " + name);
        detailsName.setText(name);
        detailsAgeId.setText("Age: " + String.valueOf(age));
        detailsProfession.setText("Profession: " + profession);
    }

}
