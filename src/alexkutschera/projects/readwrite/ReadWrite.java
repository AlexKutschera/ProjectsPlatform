
/*
 * 2017 Alexander Albers
 */
package alexkutschera.projects.readwrite;

import alexkutschera.Main;
import alexkutschera.ProjectPane;
import javafx.fxml.FXMLLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class ReadWrite extends ProjectPane {

    public static BufferedReader reader;
    public static BufferedWriter write;

    public ReadWrite() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("readWrite.fxml"));
            this.getChildren().add(loader.load());
            Main.controller = loader.getController();
        } catch (Exception e) {

        }
    }

    @Override
    public String getTitle() {
        return "Lesen/Schreiben";
    }
}