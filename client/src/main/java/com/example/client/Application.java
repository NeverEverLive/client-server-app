package com.example.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    String url = "http://localhost:8080";

    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 400);
        Parent content = FXMLLoader.load(getClass().getResource("select.fxml"));
        BorderPane root = new BorderPane();

        root.setCenter(content);
        group.getChildren().add(root);
        stage.setTitle("Select");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}