/*
 * 2017 Alexander Kutschera
 */

package alexkutschera;

import alexkutschera.projects.sampleproject.SampleProject;
import alexkutschera.projects.volumeproject.VolumeProject;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class Main extends Application {

    private static MainController controller;

    private static ObservableList<ProjectPane> projectPanes = FXCollections.observableArrayList();
    private static FilteredList<ProjectPane> filtedProjectPanes = new FilteredList<>(projectPanes);

    @Override
    public void start(Stage primaryStage) throws Exception{

        // init projects and add to projects list
        projectPanes.add(new SampleProject()); //TODO remove or replace with another Project
        projectPanes.add(new VolumeProject());

        // init GUI
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        primaryStage.setTitle("Projects Platform");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // init projects list
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
        controller.projects_list.setItems(filtedProjectPanes);

        // init search
        controller.projects_search.textProperty().addListener((observable, oldValue, newValue) -> filtedProjectPanes.setPredicate(projectPane -> projectPane.getTitle().toLowerCase().contains(newValue.toLowerCase())));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
