package com.example.fruitapp;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler {
    private Label title;
    private Label response;
    private Label selected;

    private CheckBox bananaCB;
    private CheckBox mangoCB;
    private CheckBox papayaCB;
    private CheckBox grapefruitCB;
    private String fruits;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Favourite Fruit App");
        title = new Label("What fruits do you like?");
        response = new Label("");
        selected = new Label("");

        bananaCB = new CheckBox("Banana");
        mangoCB = new CheckBox("Mango");
        papayaCB = new CheckBox("Papaya");
        grapefruitCB = new CheckBox("Grapefruit");

        // We add all of our controls
        FlowPane flowPaneRoot = new FlowPane(Orientation.VERTICAL, 5, 5);
        flowPaneRoot.setAlignment(Pos.CENTER);
        flowPaneRoot.getChildren().add(title);
        flowPaneRoot.getChildren().addAll(bananaCB, mangoCB, papayaCB, grapefruitCB, response, selected);
        showAll();

        // Attach event listeners to our checkboxes
        // We have 6 checkboxes here that means we have to create 6 event listeners or actions to each checkbox which is totally fine but that's a lot of work and unnecessary work.
        // We are going to make sure this class have actually implements an action event listener that way we can fetch that action and select which action to take.
        // Instead of having 6 event listeners or action to each check box we are going to implement just in one handle method.
        // And within that method the onclick or action method to check which items or which controls was checked.
        bananaCB.setOnAction(this);
        mangoCB.setOnAction(this);
        papayaCB.setOnAction(this);
        grapefruitCB.setOnAction(this);

        // Set up the stage and scene
        Scene scene = new Scene(flowPaneRoot, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    public void showAll() {
        fruits = "";
        if(bananaCB.isSelected()) fruits += " Banana";
        if(mangoCB.isSelected()) fruits += " Mango";
        if(papayaCB.isSelected()) fruits += " Papaya";
        if(grapefruitCB.isSelected()) fruits += " Grapefruit";
        selected.setText("Fruits selected: " + fruits);
    }


    // this event object that we have been passed will allow us to check which of these have been selected. Using one method we can check all of them.
    @Override
    public void handle(Event event) {
        Object fruitChecked = event.getSource();
        // getSource() here gives us the object that we have clicked or checked.
        if(bananaCB.equals(fruitChecked)) {
            if(bananaCB.isSelected()) {
                response.setText("Banana selected.");
            } else {
                response.setText("Banana cleared!");
            }
            showAll();
        }
        else if(mangoCB.equals(fruitChecked)) {
            if(mangoCB.isSelected()) {
                response.setText("Mango selected.");
            } else {
                response.setText("Mango cleared!");
            }
            showAll();
        }
        else if(papayaCB.equals(fruitChecked)) {
            if(papayaCB.isSelected()) {
                response.setText("Papaya selected.");
            } else {
                response.setText("Papaya cleared!");
            }
            showAll();
        }
        else if(grapefruitCB.equals(fruitChecked)) {
            if(grapefruitCB.isSelected()) {
                response.setText("Grapefruit selected.");
            } else {
                response.setText("Grapefruit cleared!");
            }
            showAll();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}