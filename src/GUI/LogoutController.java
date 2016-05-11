/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domein.DomeinController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ewout
 */
public class LogoutController implements Initializable {
    DomeinController dc;
    private OverzichtSchermController ozc;

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
    @FXML
    private ImageView imgView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        naamTxt.setText(dc.getGeselecteerd().getNaam());
        naamTxtField.setText(dc.getGeselecteerd().getNaam());
        emailTxtField.setText(dc.getGeselecteerd().getEmail());
        imgView.setImage(new Image(dc.getGeselecteerd().getFotoPath().toURI().toString()));
    } 
    public void naarOverzichtScherm(ActionEvent event) throws IOException {
       Stage stage = (Stage) terugButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        ozc = dc.getOzc();
        dc.setOzc(ozc);
        dc.getOzc().setDc(dc);
        loader.setLocation(getClass().getResource("OverzichtScherm.fxml"));
        loader.setController(dc.getOzc());
        Parent root = loader.load();
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
            //dc.getGeselecteerd().setNaam(naamTxt.get);
            //dc.getGeselecteerd().setEmail(null);
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
        @FXML
    public void saveAlleSchermen(ActionEvent event)throws IOException{
        if(dc.getStuurtechniekenScene()!=null){
            takeSnapShot(dc.getStuurtechniekenScene(), dc.getGeselecteerd().getNaam().replaceAll(" ", "")+"_Stuurtechnieken_"+dc.getEvaluatieMatthias().getHuidigeEva().toString());
        }
        if(dc.getRijtechniekenScene()!=null){
            takeSnapShot(dc.getRijtechniekenScene(), dc.getGeselecteerd().getNaam().replaceAll(" ", "")+"_Rijtechnieken_"+dc.getEvaluatieMatthias().getHuidigeEva().toString());
        }
        if(dc.getOverzichtScene()!=null){
            takeSnapShot(dc.getOverzichtScene(), dc.getGeselecteerd().getNaam().replaceAll(" ", "")+"_Overzicht_"+dc.getEvaluatieMatthias().getHuidigeEva().toString());
        }
        if(dc.getAttitudeScene()!=null){
            takeSnapShot(dc.getAttitudeScene(), dc.getGeselecteerd().getNaam().replaceAll(" ", "")+"_Attitude_"+dc.getEvaluatieMatthias().getHuidigeEva().toString());
        }
    }
    
    @FXML
    public void takeSnapShot(Scene scene,String naam){
        WritableImage writableImage = 
            new WritableImage((int)scene.getWidth(), (int)scene.getHeight());
        scene.snapshot(writableImage);
         
        File file = new File(naam+".png");
        
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            System.out.println("snapshot saved: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
