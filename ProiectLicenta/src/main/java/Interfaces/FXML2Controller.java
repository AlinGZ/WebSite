/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import static formulas.Formule.administrationCommission;
import static formulas.Formule.computeInterestRate;
import static formulas.Formule.computeMonthlyPayment;
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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author gigisan
 */
 
     
public class FXML2Controller implements Initializable {
     @FXML
    private LineChart<?, ?> g1;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private LineChart<?, ?> g2;

    @FXML
    private CategoryAxis x1;

    @FXML
    private NumberAxis y1;
    @FXML
    private Button showD;
     @FXML
    private Button exit2;
     @FXML
    public TextArea text1;
     @FXML
    private void exit2ButtonAction(ActionEvent event) throws IOException {
            exit2.setOnAction(e->Platform.exit());
     
    }
    @FXML
    private void showDButtonAction(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("scene1.fxml"));
             try {
                 loader.load();
                 
             } catch (Exception ex) {
                 Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
             }
             Scene1Controller controller1 = loader.getController();
           
         try {
             formulas.Test.insertUser(controller1.getLastName(),controller1.getFirstName(),controller1.getAge(),controller1.getGender(),controller1.getPeriod(),controller1.getAmount(),controller1.getSalary());
             formulas.Test.getUserInfo(text1);
             
             XYChart.Series series = new XYChart.Series();
             
             double interestRate;
             if(controller1.getAmount()<20000)
                interestRate=8.99;
            else if(controller1.getAmount()>20000 &&controller1.getAmount()<50000)
                interestRate=9.75;
            else
                interestRate=10.49;
             
             for(int i=0; i<controller1.getPeriod();i++)
                 
                 series.getData().add(new XYChart.Data(String.valueOf(interestRate),i));
             
             g1.getData().addAll(series);
             
              XYChart.Series series2 = new XYChart.Series();
              
             double R;
              R=administrationCommission+2*(controller1.getAmount()/(12*controller1.getPeriod()))-controller1.getAmount()/(12*controller1.getPeriod()+(interestRate/100));
             for(int i=0; i<12;i++)
                series2.getData().add(new XYChart.Data(String.valueOf(R),i));
             
             g2.getData().addAll(series2);
         } catch (IOException ex) {
             Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
   
     
   
}
 
            
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
