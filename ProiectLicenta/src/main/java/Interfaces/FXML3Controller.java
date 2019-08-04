/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gigisan
 */

public class FXML3Controller implements Initializable {

    /**
     * 
     * Initializes the controller class.
     */
    @FXML
    private Button back2;
    @FXML
    private Button exit3;
     @FXML
    private Button spred;
     @FXML
    public TextArea text2;
     
     @FXML
    private void exit3ButtonAction(ActionEvent event) throws IOException {
            exit3.setOnAction(e->Platform.exit());
     
    }
    @FXML
    private void spredButtonAction(ActionEvent event) throws IOException {
            spred.setOnAction(e->{
         try {
             weka.show(text2);
         } catch (Exception ex) {
             Logger.getLogger(FXML3Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
     });
     
            
    }
     @FXML
     private void back2ResultsButtonAction(ActionEvent event) throws IOException {
       Parent root=FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene=new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(" Prediction details");
        back2.setOnAction(e->stage.setScene(scene));
        
        stage.show(); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
