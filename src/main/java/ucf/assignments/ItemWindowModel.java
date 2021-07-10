/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Douglas Glover
 */
package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemWindowModel {
    public final Stage popup = new Stage();
    void createWindow(String path, String title) {
        try {
            popup.setTitle(title);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            popup.setScene(scene);
            popup.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    void closeWindow()
    {
        popup.close();
    }
}
