/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domein.DomeinController;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class NieuweLlnSchermController {
    
    DomeinController dc;

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }

    @FXML
    private Label naamLbl;

    @FXML
    private Label inschrijfNummerLbl;

    @FXML
    private Label emailLbl;

    @FXML
    private TextField naamTxtField;

    @FXML
    private TextField inschrijfNummerTxtField;

    @FXML
    private TextField emailTxtField;

    @FXML
    private Text messageLbl;
    
    @FXML
    private Button terugNaarLoginButton;
    
    @FXML
    private ImageView imgView;

    
//    public NieuweLlnSchermController(DomeinController dc) {
//        this.dc=dc;
//    }
    private File imgPath;
     private Desktop desktop = Desktop.getDesktop();
    
    public boolean naamIsOke() {
        String naam = naamTxtField.getText();
        return naam != null &&naam.matches("^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$");
    }

    public boolean inschrijvingsNrIsOke() {
        String nummer = inschrijfNummerTxtField.getText();
        //voorwaarde voor het controlleren of het nummer nog niet geregistreerd is voegen we later toe
        return nummer != null && nummer.matches("[0-9]+");
    }

    public boolean emailIsOke() {
        String email = emailTxtField.getText();
        //voorwaarde voor het controlleren of het emailadres nog niet geregistreerd is voegen we later toe
        return email != null && email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public void slaNaamOp(ActionEvent event) throws IOException {
        if (naamIsOke()&& inschrijvingsNrIsOke()&& emailIsOke()) {
            //code voor naar de DB weg te schrijven en te controlleren of het effectief weggeschreven is
            messageLbl.setText("Opslaan geslaagd!");
//            dc.voegLeerlingToe(new Leerling(inschrijfNummerTxtField.getText(),naamTxtField.getText(),new File("src/images/Boom.png"),emailTxtField.getText()));
            veranderScherm();
        } else {
            String bericht = "Opslaan niet geslaagd... \nHet volgende is fout gelopen:";
            if (!naamIsOke()) {
                bericht += "\n-Naam is niet geldig.";
            }
            if (!inschrijvingsNrIsOke()) {
                bericht += "\n-InschrijvingsNummer is niet geldig.";
            }
            if (!emailIsOke()) {
                bericht += "\n-Email is niet Geldig.";
            }
            messageLbl.setText(bericht);
        }
    }
    
    public void veranderScherm() throws IOException{
        Stage stage = (Stage) naamTxtField.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("OverzichtScherm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
     public void terugNaarLoginScherm(ActionEvent event) throws IOException{
        Stage stage = (Stage) terugNaarLoginButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     public void kiesFoto(ActionEvent event) throws IOException{
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Kies een foto");
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        ); 
        imgPath = fileChooser.showOpenDialog(naamTxtField.getScene().getWindow());
        if (imgPath != null) {
            openFile(imgPath);
        }
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
     }
     
     
     private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                NieuweLlnSchermController.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
}
