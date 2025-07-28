package com.example.effectsandtransformation;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler {
    private Button rotateButton;
    private Button blurButton;
    private Button scaleButton;
    private Rotate rotate;
    private double angle;
    private double blurVal;
    private BoxBlur blur;
    private double scaleFactor;
    private Scale scale;
    private Reflection reflection;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("App life cycle");
        rotateButton = new Button("Rotate");
        blurButton = new Button("Blur off");
        scaleButton = new Button("Scale");
        rotate = new Rotate();
        angle = 0.0;
        blurVal = 1.0;
        blur = new BoxBlur(1.0, 1.0, 1);
        scaleFactor = 0.6;
        scale = new Scale(scaleFactor, scaleFactor);
        reflection = new Reflection();

        // Register our buttons
        rotateButton.setOnAction(this);
        blurButton.setOnAction(this);
        scaleButton.setOnAction(this);

        Label reflect = new Label("Reflection adds visual sparkle");
        FlowPane flowPaneRoot = new FlowPane(15, 15);
        flowPaneRoot.setAlignment(Pos.CENTER);
        flowPaneRoot.getChildren().addAll(rotateButton, blurButton, scaleButton, reflect);

        // set up scene and stage
        Scene scene = new Scene(flowPaneRoot, 200, 150);
        stage.setScene(scene);
        stage.show();

        // setup transformation
        rotateButton.getTransforms().add(rotate);
        scaleButton.getTransforms().add(scale);
        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);

        // Use our label and apply the reflection effect
        reflect.setEffect(reflection);
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

        if(event.getSource().equals(blurButton)) {
            // each time button is pressed, it's blur is changed.
            if(blurVal == 10.0) {
                blurVal = 1.0;
                blurButton.setEffect(null);
                blurButton.setText("Blur off");
            } else {
                blurVal++;
                blurButton.setEffect(blur);
                blurButton.setText("Blur On");
            }
            blur.setWidth(blurVal / 2);
            blur.setHeight(blurVal / 2);
        }

        if(event.getSource().equals(scaleButton)) {
            scaleFactor += 0.1;
            if(scaleFactor > 1.5) {
                scaleFactor = 0.6;
            }

            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        }
    }
}