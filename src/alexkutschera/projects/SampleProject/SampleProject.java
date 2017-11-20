/*
 * Copyright (c) 2017. AlexKutschera
 */

package alexkutschera.projects.SampleProject;

import alexkutschera.ProjectPane;
import javafx.scene.control.Label;

public class SampleProject extends ProjectPane {

    public SampleProject() {
        this.getChildren().add(new Label("Test"));
    }

    @Override
    public String getTitle() {
        return "SAMPLE";
    }
}
