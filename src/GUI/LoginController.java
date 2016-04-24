/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domein.DomeinController;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class LoginController{
    
    DomeinController dc;

    private NieuweLlnSchermController nlc;
    
    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }
 
    @FXML
    private Button zoekButton;
    
    @FXML
    private Button nieuwButton;
    
//    private DomeinController dc = new DomeinController();
//    ZoekLlnSchermController zls = new ZoekLlnSchermController(dc);
    
    public void veranderScherm(ActionEvent event) throws IOException{
        Stage stage = (Stage) nieuwButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ZoekLlnScherm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void naarNieuwLlnScherm(ActionEvent event) throws IOException{
        Stage stage = (Stage) zoekButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("NieuweLlnScherm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }  
    
}
