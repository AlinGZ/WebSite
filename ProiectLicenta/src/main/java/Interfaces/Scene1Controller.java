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
import javafx.event.EventHandler;
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
public class Scene1Controller implements Initializable, EventHandler<ActionEvent> {
    
    @FXML
    public TextField last;
    @FXML
    public TextField first;
    @FXML
    public TextField gender;
    @FXML
    public TextField age;
    @FXML
    public TextField period;
    @FXML
    public TextField amount;
    @FXML
    public TextField salary;
    @FXML
    private Button see_results;
    @FXML
    private Button pred;
    @FXML
    private Button exit1;
    
    private static String lastName;
    private static String firstName;
    private static String gender2;
    private static int age2;
    private static int period2;
    private static double amount2;
    private static double salary2;
    
    String getLastName(){
        return lastName;
    }
    String getFirstName(){
        return firstName;
    }
    String getGender(){
        return gender2;
    }
    
    int getAge() {
        return age2;
    }
    int getPeriod() {
        return period2;
    }
    double getAmount() {
        return amount2;
    }
    double getSalary() {
        return salary2;
    }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showPredButtonAction(ActionEvent event) throws IOException, Exception {
        Parent root=FXMLLoader.load(getClass().getResource("FXML3.fxml"));
        Scene scene=new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(" Prediction details");
        pred.setOnAction(e->stage.setScene(scene));
        
        
        stage.show(); 
//        pred.setOnAction(e->{
//            try {
//                weka.show(text2);
//            } catch (Exception ex) {
//                Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        
//       stage.show();
        
        
    }
    
    @FXML
private void showResultsButtonAction(ActionEvent event) throws IOException {
    
    lastName = last.getText();
    firstName = first.getText();
    gender2=gender.getText();
    age2=Integer.parseInt(age.getText());
    period2=Integer.parseInt(period.getText());
    amount2=Double.parseDouble(amount.getText());
    salary2=Double.parseDouble(salary.getText());
       
    Parent root=FXMLLoader.load(getClass().getResource("FXML2.fxml"));
        Scene scene=new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(" See results details");
        see_results.setOnAction(e->stage.setScene(scene));
        
        
        stage.show(); 
    }
    @FXML
    private void exit1ButtonAction(ActionEvent event) throws IOException {
            
     exit1.setOnAction(e->Platform.exit());
    }
    
//     Parent root=FXMLLoader.load(getClass().getResource("FXML.fxml"));
//         Scene scene = new Scene(root,770,600);
//          Stage stage=new Stage(StageStyle.DECORATED);
//        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
//        primaryStage.setTitle("Main application");
//               primaryStage.getadd(new Image("/Interfaces/image3.jpeg"));
//               primaryStage.setScene(scene);
//               stage.show();
//        primaryStage.show();

    @Override
    public void handle(ActionEvent event) {
        
         
        
    }

    
}
