package com.example.effectsandtransformation;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler {
    private Button rotateButton;
    private Button blurButton;
    private Button scaleButton;
    private Rotate rotate;
    private double angle;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("App life cycle");
        rotateButton = new Button("Rotate");
        blurButton = new Button("Blur off");
        scaleButton = new Button("Scale");
        rotate = new Rotate();
        angle = 0.0;

        // Register our buttons
        rotateButton.setOnAction(this);
        blurButton.setOnAction(this);
        scaleButton.setOnAction(this);

        Label reflect = new Label("Reflection adds visual sparkle");
        FlowPane flowPaneRoot = new FlowPane(5, 5);
        flowPaneRoot.setAlignment(Pos.CENTER);
        flowPaneRoot.getChildren().addAll(rotateButton, blurButton, scaleButton, reflect);

        // set up scene and stage
        Scene scene = new Scene(flowPaneRoot, 400, 250);
        stage.setScene(scene);
        stage.show();

        rotateButton.getTransforms().add(rotate);
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(Event event) {
        if(event.getSource().equals(rotateButton)) {
            angle += 15.0;
            rotate.setAngle(angle);
            rotate.setPivotX(rotateButton.getWidth() / 2);
            rotate.setPivotY(rotateButton.getHeight() / 2);
        }
    }
}