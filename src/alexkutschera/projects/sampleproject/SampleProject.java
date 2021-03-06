
/*
 * 2017 Alexander Kutschera
 */
package alexkutschera.projects.sampleproject;

import alexkutschera.ProjectPane;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class SampleProject extends ProjectPane {

    private SampleProjectController controller;

    public SampleProject() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sampleproject.fxml"));
            this.getChildren().add(loader.load());
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTitle() {
        return "Sample";
    }

}
