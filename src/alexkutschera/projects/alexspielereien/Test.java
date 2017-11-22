
/*
 * 2017 Alexander Albers
 */
package alexkutschera.projects.alexspielereien;

import alexkutschera.ProjectPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;


public class Test extends ProjectPane {

    private TestController controller;
    public Button cmdReset;

    public Test() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
            this.getChildren().add(loader.load());
            controller = loader.getController();

            //Code
            controller.txtBox.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.matches("Hallo"))
                {
                    controller.lblAusgabe.setText("Hallo");
                }
            });
            cmdReset = new Button("Reset");
            cmdReset.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event)
                {
                    controller.lblAusgabe.setText("");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTitle() {
        return "Test";
    }
}