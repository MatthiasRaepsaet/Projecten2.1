/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domein.DomeinController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ewout
 */
public class LogoutController implements Initializable {
    
    DomeinController dc;

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }

    @FXML
    private Button terugButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button opslaanButton;
    @FXML
    private TextField naamTxtField;
    @FXML
    private TextField emailTxtField;
    @FXML
    private Text naamTxt;
    @FXML
    private Text errorTxt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //moet anders later
        naamTxt.setText("Joske Vermeulen");
        naamTxtField.setText("Joske Vermeulen");
        emailTxtField.setText("joske@vermeulen.be");
    } 
    public void naarOverzichtScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) terugButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("OverzichtScherm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     
    public void naarLoginScherm(ActionEvent event) throws IOException {
        Stage stage = (Stage) homeButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public boolean naamIsOke() {
        String naam = naamTxtField.getText();
        return naam != null &&naam.matches("^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$");
    }

    public boolean emailIsOke() {
        String email = emailTxtField.getText();
        //voorwaarde voor het controlleren of het emailadres nog niet geregistreerd is voegen we later toe
        return email != null && email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public void slaNaamOp(ActionEvent event) throws IOException {
        if (naamIsOke()&&emailIsOke()) {
            //code voor naar de DB weg te schrijven en te controlleren of het effectief weggeschreven is
            errorTxt.setFill(Color.GREEN);
            errorTxt.setText("Opslaan geslaagd!");
        } else {
            String bericht = "Opslaan niet geslaagd... \nHet volgende is fout gelopen:";
            errorTxt.setFill(Color.RED);
            if (!naamIsOke()) {
                bericht += "\n-Naam is niet geldig.";
            }
            if (!emailIsOke()) {
                bericht += "\n-Email is niet Geldig.";
            }
            errorTxt.setText(bericht);
        }
    }
}
