/*
 * Copyright (c) 2017. AlexKutschera
 */

package alexkutschera.projects.volumeproject;

import alexkutschera.ProjectPane;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class VolumeProject extends ProjectPane {

    private VolumeProjectController controller;
    private float inLength = 0, inWidth = 0, inHeight = 0, outVolume = 0;

    public VolumeProject() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("volumeproject.fxml"));
            this.getChildren().add(loader.load());
            controller = loader.getController();

            controller.in_length.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                    inLength = Float.parseFloat(newValue);
                    calculate();
                }
            });
            controller.in_width.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                    inWidth = Float.parseFloat(newValue);
                    calculate();
                }
            });
            controller.in_height.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                    inHeight = Float.parseFloat(newValue);
                    calculate();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calculate() {
        outVolume = inLength * inWidth * inHeight;
        controller.out_volume.setText(String.valueOf(outVolume));
    }

    @Override
    public String getTitle() {
        return "Volumen";
    }

}
