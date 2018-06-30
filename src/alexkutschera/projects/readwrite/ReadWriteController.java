/*
 * 2017 Alexander Albers
 */

package alexkutschera.projects.readwrite;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class ReadWriteController {
    //init Elemente
    public Label lblOutput;
    public Button btnReadFile, btnReadLine;
    public TextField txtLine = new TextField();

    public ReadWriteController(){

    }
    public void readFile() {
        try {
            ReadWrite.reader = new BufferedReader(new FileReader("Test.txt"));
        } catch (FileNotFoundException e) {
            File file = new File("Test.txt");
        }

    }

}
