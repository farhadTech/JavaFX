package com.example.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Label myLabel;
    private TextField nameTextField;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Button button = new Button();
        button.setText("Click Me!");

        button.setOnAction(new EventHandler<ActionEvent>(){
            int count = 0;
            @Override
            public void handle(ActionEvent event) {
                count++;
                if(count % 2 == 1){
                    String name = nameTextField.getText().trim();
                    button.setText("Yes! Clicked");
                    if(name.equals("")){
                        nameTextField.setPromptText("Enter your name");
                    } else {
                        myLabel.setText("Hello, " + name + "!");
                    }
                } else {
                    button.setText("Click Me!");
                    nameTextField.setText("Your new name is not set yet!");
                }
            }
        });

        myLabel = new Label();
        nameTextField = new TextField();

        myLabel.setText("This is my label");
        nameTextField.setPromptText("Enter your name");

//        StackPane root = new StackPane();
        FlowPane flowPaneRoot = new FlowPane(10, 10);
        flowPaneRoot.getChildren().add(button);
        flowPaneRoot.getChildren().add(myLabel);
        flowPaneRoot.getChildren().add(nameTextField);
        flowPaneRoot.setAlignment(Pos.CENTER);
        Scene scene = new Scene(flowPaneRoot, 250, 200);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
