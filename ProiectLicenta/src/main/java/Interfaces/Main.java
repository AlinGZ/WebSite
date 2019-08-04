/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author gigisan
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        String sceneFile = "/Interfaces/scene1.fxml";
    Parent root = null;
    URL    url  = null;
    try
    {
        url  = getClass().getResource( sceneFile );
        root = FXMLLoader.load( url );
        System.out.println( "  fxmlResource = " + sceneFile );
    }
    catch ( Exception ex )
    {
        System.out.println( "Exception on FXMLLoader.load()" );
        System.out.println( "  * url: " + url );
        System.out.println( "  * " + ex );
        System.out.println( "    ----------------------------------------\n" );
        throw ex;
    }
        Scene scene = new Scene(root, 770, 600);
        Stage stage = new Stage(StageStyle.DECORATED);
        primaryStage.setTitle("Main application");
        primaryStage.setScene(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
