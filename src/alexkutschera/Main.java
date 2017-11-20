/*
 * Copyright (c) 2017. AlexKutschera
 */

package alexkutschera;

import alexkutschera.projects.EmptyProject.EmptyProject;
import alexkutschera.projects.SampleProject.SampleProject;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class Main extends Application {

    private static MainController controller;

    private static ObservableList<ProjectPane> projectPanes = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Init Projects and add to Projects list
        projectPanes.add(new SampleProject()); //TODO remove or replace with another Project
        projectPanes.add(new EmptyProject()); //TODO remove or replace with another Project

        // Init GUI
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        primaryStage.setTitle("Projects Platform");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // Init Projects List
        controller.projects_list.setCellFactory(param -> new ListCell<ProjectPane>() {
            @Override
            protected void updateItem(ProjectPane item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty && item != null) {
                    setText(item.getTitle());
                    setOnMouseClicked(event -> {
                        controller.project_pane.getChildren().removeAll(controller.project_pane.getChildren());
                        controller.project_pane.getChildren().add(item);
                    });
                } else {
                    setText(null);
                    setOnMouseClicked(null);
                }
            }
        });
        controller.projects_list.setItems(projectPanes);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
